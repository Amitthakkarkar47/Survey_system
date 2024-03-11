package com.project.model;

import java.util.List;

public class Survey {
    private String title;
    private List<Question> questions;
    // Other survey-related fields, getters, setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
    
}
