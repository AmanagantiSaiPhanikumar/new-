package com.capg.test.ui;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capg.test.bean.Questions;
import com.capg.test.repository.MyRepository;
import com.capg.test.service.IQuestions;
import com.capg.test.service.QuestionsImp;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IQuestions service = new QuestionsImp();
		QuestionsImp services = new QuestionsImp();

		Map resultMap = MyRepository.goMap();

		int questionAdded = 0;
		int questionUpdated = 0;

		while (true) {

			System.out.println("What you want to operate ");
			System.out.println("1. add Question");
			System.out.println("2.update Question ");
			System.out.println("3.delete Question ");
			System.out.println(resultMap);

			Questions question = new Questions();
			int choice = 0;
			Scanner scan = null;
			boolean option = false;
			do {
				System.out.println("enter the choice");
				try {
					scan = new Scanner(System.in);
					choice = scan.nextInt();
					option = true;
				} catch (InputMismatchException e) {

					System.err.println("Input should  be in integers");

				}
			} while (!option);
			scan.nextLine();

			switch (choice) {
			case 1:
				System.out.println("**YOU SELECTED ADDING OF QUESTIONS**");

				int questionId = 0;
				int x = 1;
				String questionTitle = null;

				boolean flag = false;

				do {
					System.out.println("**ENTER FOLLOWING DETAILS**");
					System.out.println(" enter the question  id to be added");
					try {
						scan = new Scanner(System.in);
						questionId = scan.nextInt();
						String input = String.valueOf(questionId);
						if (questionId <= 0 || input.matches("[a-zA-Z]")) {
							throw new InputMismatchException();
						}
						flag = true;

					} catch (InputMismatchException ie) {
						System.err.println("Question id  should be in integers");

					}

				} while (!flag);
				// scan.close();
				scan.nextLine();

				// System.out.println();
				boolean title = false;
				do {

					System.out.println(" enter the question  title to be added");
					try {
						questionTitle = scan.nextLine();
						String str = questionTitle.toString();
						if (str.length() < 4 || str.equals(str.matches("[a-zA-Z]"))) {

							throw new MyException("Entered invalid Question title");
						}
						title = true;
					}

					catch (MyException e) {
						System.err.println(e.getMessage());

					}
				} while (!title);

				int n = 4;

				System.out.println(" enter the question  option to be added");
				String[] questionOption = new String[n];
				for (int i = 0; i < n; i++) {
					questionOption[i] = scan.next();
				}
				int questionAnswer = 0;
				boolean correct = false;
				do {

					System.out.println(" enter the question  answer to be added");

					try {
						scan = new Scanner(System.in);
						questionAnswer = scan.nextInt();
						String answer = questionTitle.toString();
						if (answer.matches("[a-zA-Z]") || questionAnswer < 0 || questionAnswer > 3) {
							throw new InputMismatchException();
						}
						correct = true;
					} catch (InputMismatchException e) {

						System.err.println("Entered input is not valid");

					}
				} while (!correct);
				scan.nextLine();

				int questionMarks = 0;
				boolean report = false;
				do {
					System.out.println(" enter the question  marks to be added");

					try {
						scan = new Scanner(System.in);
						questionMarks = scan.nextInt();
						String marks = String.valueOf(questionMarks);
						if (marks.matches("[a-zA-Z]") || questionMarks < 0 || questionMarks > 5) {
							throw new InputMismatchException();
						}
						report = true;

					} catch (InputMismatchException e) {

						System.err.println("Entered input is not valid");

					}
				} while (!report);
				question.setQuestionId(questionId);
				question.setQuestionTitle(questionTitle);
				question.setQuestionOption(questionOption);
				question.setQuestionAnswer(questionAnswer);
				question.setQuestionMarks(questionMarks);

				boolean isValid = QuestionsImp.userValidations(question);
				if (isValid) {

					System.out.println("valid");
					questionAdded = service.addQuestion(question);
				} else {
					System.out.println("invalid");
				}

				if (questionAdded == 1) {
					System.out.println("Questions are added");
				}

				break;

			case 2:
				System.out.println("**YOU SELECTED UPDATING OF QUESTIONS**");
				int qId = 0;
				boolean updates = false;
				do {

					System.out.println("**ENTER FOLLOWING DETAILS**");
					System.out.println("enter the questionId");

					try {
						scan = new Scanner(System.in);
						qId = scan.nextInt();
						String input = String.valueOf(qId);

						if (qId <= 0 || input.matches("[a-zA-Z]")) {
							throw new InputMismatchException();

						}

						else if (qId != 0 || !input.equals(input.matches("[a-zA-Z]"))) {

							Set<Integer> set = resultMap.keySet();
							Integer array[] = new Integer[set.size()];
							array = set.toArray(array);
							for (Integer i : set) {
								try {
									if (i != qId) {
										throw new NullPointerException();

									}

								} catch (NullPointerException e) {
									System.err.print("enterd value which is not in list");
								}

							}

						}
					} catch (InputMismatchException e) {
						System.err.println("Invalid input");
					}

				} while (!updates);

				Map<Integer, Questions> map = services.getMap();
				Questions ques = map.get(qId);
				int questionMark = 0;
				boolean entry = false;
				do {

					System.out.println("enter the marks you want to update");
					try {
						scan = new Scanner(System.in);
						questionMark = scan.nextInt();
						String input = String.valueOf(questionMark);

						if (questionMark < 0 || input.matches("[a-zA-Z]")) {
							throw new InputMismatchException();
						}
						entry = true;
					} catch (InputMismatchException e) {
						System.err.println("Invalid input, input should be integers");
					}
				} while (!entry);

				int updateQuestion = services.updateQuestion(ques, questionMark);

				if (questionUpdated == 1) {
					System.out.println("Questions are updated");
				}

				break;

			case 3:
				System.out.println("**YOU SELECTED DELETING OF QUESTIONS**");
				int id = 0;
				boolean remove = false;
				do {

					System.out.println("**ENTER FOLLOWING DETAILS**");
					System.out.println("enter the question to be deleted");

					try {
						id = scan.nextInt();
						String input = String.valueOf(id);
						if (id < 0 || input.matches("[a-zA-Z]")) {
							throw new InputMismatchException();
						}
						remove = true;
					} catch (InputMismatchException e) {
						System.err.println("enter valid id");

					}
				} while (!remove);
				int deletedQuestion = service.deleteQuestion(id);
				System.out.println(deletedQuestion);
				if (deletedQuestion == 1) {
					System.out.println("question is deleted");
				}
				break;
			case 4:
				System.out.println("**YOU SELECTED TOTAL MARKS OF QUESTIONS**");
				int mark = 0;
				boolean input = false;
				do {
					System.out.println("**ENTER FOLLOWING DETAILS**");

					System.out.println("enter the marks");

					try {
						mark = scan.nextInt();
						String marks = String.valueOf(mark);
						if (marks.matches("[a-zA-Z]") || mark < 0 || mark > 5) {
							throw new InputMismatchException();
						}
						input = true;
					} catch (InputMismatchException e) {

						System.err.println("Entered input is not valid");

					}
				} while (!input);
				int result = service.getResult(mark);
				System.out.println(result);

				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println(" Invalid option");

				break;
			}

		}

	}
}
