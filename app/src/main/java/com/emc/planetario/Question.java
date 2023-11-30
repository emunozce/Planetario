package com.emc.planetario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String question;
    private String correctAnswer;
    private String incorrectAnswer1;
    private String incorrectAnswer2;
    public Question(String question, String correctAnswer, String incorrectAnswer1, String incorrectAnswer2) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer1 = incorrectAnswer1;
        this.incorrectAnswer2 = incorrectAnswer2;
    }
    public String getQuestion() {
        return question;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public List<String> getShuffledAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add(correctAnswer);
        answers.add(incorrectAnswer1);
        answers.add(incorrectAnswer2);
        // Barajear las respuestas para un orden aleatorio
        Collections.shuffle(answers);
        return answers;
    }
}

