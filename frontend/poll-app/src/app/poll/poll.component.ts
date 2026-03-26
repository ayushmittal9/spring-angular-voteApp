
import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.Service';
import { Poll, OptionVote } from '../poll.models';  // assuming OptionVote is exported too
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface NewPoll {
  questions: string;
  options: OptionVote[];
}

@Component({
  selector: 'app-poll',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css',
})
export class PollComponent implements OnInit {
  // ── Data for displaying existing polls ──
  polls: Poll[] = [];

  // ── Form data for creating a NEW poll (NO id field) ──
  newPoll: NewPoll = {
    questions: '',
    options: [
      { optionText: '', voteCount: 0 },
      { optionText: '', voteCount: 0 },
    ],
  };

  constructor(private pollService: PollService) {}

  ngOnInit(): void {
    this.loadPolls();
  }

  loadPolls(): void {
    this.pollService.getPolls().subscribe({
      next: (data) => {
        this.polls = data;
      },
      error: (err) => {
        console.error('Error fetching polls:', err);
        // Optional: show user-friendly message
        // this.errorMessage = 'Could not load polls. Please try again later.';
      },
    });
  }

  addOption(): void {
    this.newPoll.options.push({ optionText: '', voteCount: 0 });
  }

  removeOption(index: number): void {
    if (this.newPoll.options.length > 2) {
      this.newPoll.options.splice(index, 1);
    }
  }

  createPoll(): void {
    // Basic client-side validation
    if (!this.newPoll.questions.trim()) {
      alert('Please enter a question');
      return;
    }
    if (this.newPoll.options.some((opt) => !opt.optionText.trim())) {
      alert('All options must have text');
      return;
    }

    // We send object WITHOUT id → backend should generate it
    this.pollService.createPoll(this.newPoll as Poll).subscribe({
      next: (createdPoll) => {
        this.polls.push(createdPoll);
        this.resetPoll();
        // Optional: success feedback
        // alert('Poll created successfully!');
      },
      error: (err) => {
        console.error('Error creating poll:', err);
        alert('Failed to create poll. Please try again.');
      },
    });
  }

  resetPoll(): void {
    this.newPoll = {
      questions: '',
      options: [
        { optionText: '', voteCount: 0 },
        { optionText: '', voteCount: 0 },
      ],
    };
  }

  vote(pollId: number, optionIndex: number) {
    this.pollService.vote(pollId, optionIndex).subscribe({
      next: () => {
        const poll = this.polls.find(p => p.id === pollId);
        if (poll) {
          poll.options[optionIndex].voteCount++;
        }
      },
      error: (error) => {
        console.error("Error voting on a poll: ", error);
      }
    });
  }

  // Helper for *ngFor with index
  trackByIndex(index: number): number {
    return index;
  }
}
