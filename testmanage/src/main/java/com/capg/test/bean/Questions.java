package com.capg.test.bean;

import java.util.Arrays;

public class Questions {

	private int questionId;
	private String questionTitle;
	private String[] questionOption;
	private int questionAnswer;
	private int questionMarks;
	private int chosenAnswer;
	private int marksScored;

	public int getQuestionId() {
		return questionId;
	}

	public Questions(int questionId, String questionTitle, int questionAnswer, int questionMarks) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;

		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
	}

	public Questions(String[] questionOption) {
		super();
		this.questionOption = questionOption;
	}

	public Questions() {
		// TODO Auto-generated constructor stub
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String[] getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(String[] questionOption) {
		this.questionOption = questionOption;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public int getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionTitle=" + questionTitle + ", questionOption="
				+ Arrays.toString(questionOption) + ", questionAnswer=" + questionAnswer + ", questionMarks="
				+ questionMarks + "]";
	}

}
