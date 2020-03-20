package com.capg.test.dao;

import java.util.Set;

import com.capg.test.bean.Questions;

public interface IQuestionsDAO {

	int addQuestion(Questions question);

	int updateQuestion(Questions question, int marks);

	int deleteQuestion(int questionId);

	int getResult(int questionMarks);

	Set<Integer> getAllQuestions(int id1);

}
