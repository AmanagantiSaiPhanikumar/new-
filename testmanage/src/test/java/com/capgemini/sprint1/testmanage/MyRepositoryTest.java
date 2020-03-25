package com.capgemini.sprint1.testmanage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.capg.test.bean.Questions;
import com.capg.test.service.QuestionsImp;

class MyRepositoryTest {
	
	QuestionsImp service;
	@BeforeAll
	public void getQues()
	{
	service=new QuestionsImp();
	}
	
Questions questionobj=new Questions();
	

	@Test
	void testDeleteQuestion() {
		questionobj.setQuestionId(1);
		int res=service.deleteQuestion(questionobj.getQuestionId());
		assertEquals(1,res);
	}

	@Test
	void testUpdateQuestion() {
	
	}

	@Test
	void testGetResults() {
		questionobj.setQuestionMarks(5);
		int res=service.getResult(questionobj.getQuestionMarks());
		assertEquals(1,res);
		
	}

}
