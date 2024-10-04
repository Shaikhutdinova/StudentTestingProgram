package org.example.repository;

import org.example.model.Answer;
import org.example.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionParser {
    public static Question parseQuestion(String line) {
        String[] partsStr = line.split(",");
        List<Answer> answers = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Answer answer = new Answer(partsStr[i], false);
            for (int j = 5; j < partsStr.length - 1; j++) {
                if (partsStr[i].equals(partsStr[j])) {
                    answer.setCorrect(true);
                }
            }
            answers.add(answer);
        }
        return new Question(partsStr[0], answers, Integer.parseInt(partsStr[partsStr.length - 1]));
    }
}
