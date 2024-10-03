package org.example;

import org.example.model.Answer;
import org.example.model.Question;
import org.example.model.User;
import org.example.service.QuestionService;
import org.example.service.QuestionServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = (QuestionServiceImpl) context.getBean(QuestionServiceImpl.class);
        List<Question> questions = questionService.getQuestions();

        System.out.print("Enter your:\n" + "1. Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("2. Group: ");
        String group = scanner.nextLine();
        User student = new User(name, group, 0);

        for (Question question : questions) {
            System.out.println(question.toString());
            System.out.println("If there are several answers, list them separated by commas");
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            System.out.println();

            String[] studentAnswers = answer.split(",");
            if (studentAnswers.length == question.getCountCorrectAnswers()) {
                int point = 0;
                for (String answ : studentAnswers) {
                    answ = answ.trim();
                    for (Answer variant : question.getVariants()){
                        if(answ.equalsIgnoreCase(variant.getVariant())){
                            point++;
                        }
                    }
                }

                if (point == question.getCountCorrectAnswers()){
                    student.setPoints(1);
                }
            }
        }
        scanner.close();

        System.out.println("You have " + student.getPoints() + " points");
    }
}