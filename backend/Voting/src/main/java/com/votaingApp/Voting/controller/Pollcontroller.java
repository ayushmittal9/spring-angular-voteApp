package com.votaingApp.Voting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votaingApp.Voting.model.Poll;
import com.votaingApp.Voting.request.Vote;
import com.votaingApp.Voting.services.PollService;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class Pollcontroller {
   private final PollService pollService;
   public Pollcontroller(PollService pollService) {
		super();
		this.pollService = pollService;
	   }
   
   
   //make a poll
   @PostMapping
   public Poll createPoll(@RequestBody Poll poll) {
	   return pollService.createPoll(poll);
   }
   
   
   //print all the polls that are present in database
   @GetMapping
   public List<Poll> getAllPolls(){
	   return pollService.getAllPolls();
   }
   
   //take a poll by its id
   @GetMapping("/{id}")
   public  ResponseEntity<Poll> getPoll(@PathVariable Long id) {
	   return pollService.getPollById(id)
			   .map(ResponseEntity::ok)
			   .orElse(ResponseEntity.notFound().build());
   }
   
   // when a user want to vote for perticular poll
   @PostMapping("/vote")
   public void vote(@RequestBody Vote vote) {
	   pollService.vote(vote.getPollId(),vote.getOptionIndex());
   }
  
}
