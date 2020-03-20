package com.capg.testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.test.bean.Questions;
import com.capg.test.service.QuestionsImp;

class OnlineTest {

	static QuestionsImp service;

	@BeforeAll
	public static void getQues() {
	service = new QuestionsImp();
	}

	Questions questionobj = new Questions();

	@Test
	void testDeleteQuestion() {

		questionobj.setQuestionId(12);
	

		int res = service.deleteQuestion(questionobj.getQuestionId());

		assertEquals(1, res);

	}

	@Test
	void testGetResult() {
		questionobj.setQuestionMarks(-5);

		int res = service.getResult(questionobj.getQuestionMarks());
		assertEquals(1, res);

	}

	

}
