package org.example;

import org.example.model.User;
import org.example.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuizService quiz = (QuizServiceImpl) context.getBean(QuizServiceImpl.class);
        UserService user = (UserServiceImpl) context.getBean(UserServiceImpl.class);
        User student = user.getStudentFromConsole();
        quiz.start(student);

        System.out.println("You have " + student.getPoints() + " points");
    }
}