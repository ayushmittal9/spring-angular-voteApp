package com.votaingApp.Voting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.votaingApp.Voting.model.OptionVote;
import com.votaingApp.Voting.model.Poll;
import com.votaingApp.Voting.repository.PollRepository;

@Service
public class PollService {

	
	private final PollRepository pollrepository;
	public PollService(PollRepository pollrepository) {
		super();
		this.pollrepository = pollrepository;
	}
	
	
	
	public Poll createPoll(Poll poll) {
		// TODO Auto-generated method stub
		return pollrepository.save(poll);
	}



	public List<Poll> getAllPolls() {
		return pollrepository.findAll();
	}





	public Optional<Poll> getPollById(Long id) {
		// TODO Auto-generated method stub
		return pollrepository.findById(id);
	}



	public void vote(Long pollId, int optionIndex) {
		// get poll from db
		Poll poll = pollrepository.findById(pollId)
				.orElseThrow( () -> new RuntimeException("poll not found"));
		//get All options
		List<OptionVote> option = poll.getOptions();
		
		//if index for vote  is not valid throw erroe
		if(optionIndex < 0 || optionIndex >= option.size()) {
			throw new IllegalArgumentException("Invalid option");
		}
		// get the selected option
		OptionVote selectedOption = option.get(optionIndex);
		//increment vote that is selected
		selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
		//save increment option in database
		pollrepository.save(poll);
		
		
		
		
	}

}
