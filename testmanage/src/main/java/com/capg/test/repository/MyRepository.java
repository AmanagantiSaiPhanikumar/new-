package com.capg.test.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.capg.test.bean.Questions;

public class MyRepository {

	static Map<Integer, Questions> map = new HashMap<Integer, Questions>();
	static Set<Integer> set = map.keySet();
	static Set<Integer> set1 = map.keySet();

	static Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

	static {
		map2.put(1, 1);
		map2.put(2, 2);

	}

	static Questions delete;
	static Questions update;

	public static Map<Integer, Questions> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Questions> map) {
		this.map = map;
	}

	public static int addQuestion(Questions question) {

		map.put(question.getQuestionId(), question);
		return 1;

	}

	public static Map<Integer, Questions> goMap() {

		return map;
	}

	public static int deleteQuestion(int questionId) {

		delete = map.remove(questionId);
		System.out.println(map);
		return 1;

	}

	public static Questions delques() {
		return delete;
	}

	public static int updateQuestion(Questions question, int questionMarks) {

		question.setQuestionMarks(questionMarks);
		update = map.put(question.getQuestionId(), question);
		System.out.println(map);

		return 1;
	}

	public static Questions updques() {
		return update;
	}

	public static int getResults(int marks) {

		Set<Integer> set1 = map2.keySet();
		int[] chosenAnswer = new int[set1.size()];

		int j = 0;
		for (int i : set1) {
			chosenAnswer[j] = i;

			j++;

		}
		Set<Integer> set2 = map.keySet();
		int[] givenAnswer = new int[set2.size()];
		int k = 0;
		for (int i : set2) {

			givenAnswer[k] = i;
			k++;

		}
		for (int l = 0; l < chosenAnswer.length; l++) {

			if (chosenAnswer[l] == givenAnswer[l]) {

				marks = marks + 5;

			}

		}

		return marks;

	}

	

}
