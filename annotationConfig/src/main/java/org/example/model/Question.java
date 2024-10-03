package org.example.model;

import java.util.List;

public class Question {
    private final String question;
    private final List<Answer> variants;
    private final int countCorrectAnswers;

    public Question(String question, List<Answer> variants, int countCorrectAnswers) {
        this.question = question;
        this.variants = variants;
        this.countCorrectAnswers = countCorrectAnswers;
    }

    public int getCountCorrectAnswers() {
        return countCorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getVariants() {
        return variants;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(question + "\n");

        for (Answer variant : variants){
            sb.append(variant.getVariant() + "\n");
        }
        return sb.toString();
    }
}
