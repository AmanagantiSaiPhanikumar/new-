package com.capg.test.dao;

import java.util.Map;
import java.util.Set;

import com.capg.test.bean.Questions;
import com.capg.test.repository.MyRepository;

public class QuestionsDAO implements IQuestionsDAO {
	public int addQuestion(Questions question) {
		// TODO Auto-generated method stub

		int add = MyRepository.addQuestion(question);

		return add;
	}

	public int updateQuestion(Questions question, int marks) {
		// TODO Auto-generated method stub

		int upd = MyRepository.updateQuestion(question, marks);

		return upd;
	}

	public int deleteQuestion(int questionId) {
		// TODO Auto-generated method stub

		int del = MyRepository.deleteQuestion(questionId);
		return del;
	}

	

	public int getResult(int questionMarks) {
		int res = MyRepository.getResults(questionMarks);
		return res;
	}

	public Map<Integer, Questions> getMap() {
		return MyRepository.getMap();
	}

	@Override
	public Set<Integer> getAllQuestions(int id1) {
		// TODO Auto-generated method stub
		return null;
	}

}
