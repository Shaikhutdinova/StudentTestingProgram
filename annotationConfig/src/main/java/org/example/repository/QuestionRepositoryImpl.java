package org.example.repository;

import org.example.model.Answer;
import org.example.model.Question;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {
    private final Resource questionsResource;

    public QuestionRepositoryImpl(Resource questionsResource) {
        this.questionsResource = questionsResource;
    }

    @Override
    public List<Question> findAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(questionsResource.getInputStream()))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] partsStr = line.split(",");
                List<Answer> answers = new ArrayList<>();
                for (int i = 1; i < 5; i++) {
                    Answer answer = new Answer(partsStr[i], false);
                    for (int j = 5; j < partsStr.length-1; j++) {
                        if(partsStr[i].equals(partsStr[j])) {
                            answer.setCorrect(true);
                        }
                    }
                    answers.add(answer);
                }

                Question question = new Question(partsStr[0], answers, Integer.parseInt(partsStr[partsStr.length-1]));
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
