package org.example.model;

public class Answer {
    private final String variant;
    private Boolean isCorrect;

    public Answer(String variant, Boolean isCorrect) {
        this.variant = variant;
        this.isCorrect = isCorrect;
    }

    public String getVariant() {
        return variant;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
