package com.votaingApp.Voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votaingApp.Voting.model.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long>{
	

}
