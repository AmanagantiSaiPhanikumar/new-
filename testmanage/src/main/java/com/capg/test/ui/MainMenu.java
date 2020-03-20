package com.capg.test.ui;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.capg.test.bean.Questions;
import com.capg.test.repository.MyRepository;
import com.capg.test.service.IQuestions;
import com.capg.test.service.QuestionsImp;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IQuestions service = new QuestionsImp();
		QuestionsImp services = new QuestionsImp();
		Scanner scan = new Scanner(System.in);

		Map map1 = MyRepository.goMap();

		int questionAdded = 0;
		int questionUpdated=0;
		
		
		while (true) {
			System.out.println("What you want to operate ");
			System.out.println("1. add Question");
			System.out.println("2.update Question ");
			System.out.println("3.delete Question ");
			System.out.println(map1);

			Questions question = new Questions();
			int choice = 0;

			try {
				choice = scan.nextInt();
				// choice = option;
			} catch (InputMismatchException e) {

				System.err.println("Input should  be in integers");

			}
			scan.nextLine();
			switch (choice) {
			case 1:
				int questionId = 0;
				String questionTitle = null;
				int questionAnswer=0;
				int questionMarks=0;
				System.out.println(" enter the question  id to be added");

				try {
					questionId = scan.nextInt();
				String input=String.valueOf(questionId);
					if(questionId<0||input.matches("[a-zA-Z]"))
					{
						throw new InputMismatchException();
					}

				} catch (InputMismatchException ie) {
					System.err.println("Question id  should be in integers");

					
				}

				scan.nextLine();
				System.out.println(" enter the question  title to be added");

				questionTitle = scan.nextLine();
				String str = questionTitle.toString();
				if (str.length() < 4 || str.equals(str.matches("[a-zA-Z]"))) {
					try {
						throw new MyException("Entered invalid Question title");
					} catch (MyException e) {
						System.err.println(e.getMessage());
				
					}

				
				} else {
					System.err.println("Invalid question title");
					break;
				}

				int n = 4;
				System.out.println(" enter the question  option to be added");
				String[] questionOption = new String[n];
				for (int i = 0; i < n; i++) {
					questionOption[i] = scan.next();
				}
				System.out.println(" enter the question  answer to be added");
				try {
					 questionAnswer = scan.nextInt();
					 String answer = questionTitle.toString();
					 if(answer.matches("[a-zA-Z]")||questionAnswer<0||questionAnswer>3)
					 {
						 throw new InputMismatchException();
					 }
				
				} catch (InputMismatchException e) {

					System.err.println("Entered input is not valid");

				}
				scan.nextLine();
				
				System.out.println(" enter the question  marks to be added");
				try {
					 questionMarks = scan.nextInt();
					 String marks = String.valueOf(questionMarks);
					 if(marks.matches("[a-zA-Z]")||questionMarks<0||questionMarks>5)
					 {
						 throw new InputMismatchException();
					 }
				
				} catch (InputMismatchException e) {

					System.err.println("Entered input is not valid");

				}

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
				System.out.println("enter the questionId");
				int qId=0;
				try {
				qId = scan.nextInt();
				String input=String.valueOf(qId);
				if(qId<0||input.matches("[a-zA-Z]"))
				{
					throw new InputMismatchException();
				}
				} catch (InputMismatchException e) {
					System.err.println("enter valid qId");
				}
				
				Map<Integer, Questions> map = services.getMap();
				Questions ques = map.get(qId);
				System.out.println("enter the marks you want to update");
				questionMarks = scan.nextInt();
				int updateQuestion = services.updateQuestion(ques, questionMarks);
				
				if (questionUpdated == 1) {
					System.out.println("Questions are updated");
				}
				
				
				
				break;
			case 3:
				int id=0;

				System.out.println("enter the question to be deleted");

				try {
					id = scan.nextInt();
					String input=String.valueOf(id);
					if(id<0||input.matches("[a-zA-Z]"))
					{
						throw new InputMismatchException();
					}
					
					
				} catch (InputMismatchException e) {
					System.err.println("enter valid id");
					
				}
				int deletedQuestion = service.deleteQuestion(id);
				System.out.println(deletedQuestion);
				if (deletedQuestion == 1) {
					System.out.println("question is deleted");
				}
				break;
			case 4:
				
				System.out.println("enter the marks");
				int mark = 0;
				
				try {
					 mark = scan.nextInt();
					 String marks = String.valueOf(mark);
					 if(marks.matches("[a-zA-Z]")||mark<0||mark>5)
					 {
						 throw new InputMismatchException();
					 }
				
				} catch (InputMismatchException e) {

					System.err.println("Entered input is not valid");

				}
				
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
