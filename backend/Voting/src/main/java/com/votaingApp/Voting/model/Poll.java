package com.votaingApp.Voting.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Poll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String questions;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public List<OptionVote> getOptions() {
		return options;
	}
	public void setOptions(List<OptionVote> options) {
		this.options = options;
	}


	@ElementCollection
	private List<OptionVote> options = new ArrayList<>();
	
	
//	@ElementCollection
//	private List<Long> votes = new ArrayList<>();
	

}
