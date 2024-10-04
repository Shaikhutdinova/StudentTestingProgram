package org.example.service;

import org.example.model.Answer;
import org.example.model.Question;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuestionService questionService;
    private final IOService reader;

    public QuizServiceImpl(QuestionService questionService, UserService userService, IOService reader) {
        this.questionService = questionService;
        this.reader = reader;
    }

    @Override
    public void start(User student) {
        List<Question> questions = questionService.getQuestions();

//        Scanner sc = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.toString());
            System.out.println("If there are several answers, list them separated by commas");
            System.out.print("Your answer: ");

            String answer = reader.readLine();
            System.out.println();

            // Проверка ответа
            if (checkAnswer(question, answer)) {
                student.setPoints(student.getPoints() + 1);
            }
        }
//        sc.close();
    }

    private boolean checkAnswer(Question question, String answer) {
        String[] studentAnswers = answer.split(",");
        if (studentAnswers.length == question.getCountCorrectAnswers()) {
            int point = 0;
            for (String answ : studentAnswers) {
                answ = answ.trim();
                for (Answer variant : question.getVariants()) {
                    if (answ.equalsIgnoreCase(variant.getVariant())) {
                        point++;
                    }
                }
            }
            return point == question.getCountCorrectAnswers();
        }
        return false;
    }
}
