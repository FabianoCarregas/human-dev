package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public class Alternative {

    private String questionExplanation;
    private int ordination;
    private String answer;
    private boolean answerCheck;
    private String answerJustification;
    private String rightAnswer;

    public Alternative(String questionExplanation,
                       boolean answerCheck,
                       String rightAnswer) {
        notBlankOrNull(questionExplanation);
        this.questionExplanation = questionExplanation;
        this.answerCheck = answerCheck;
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "questionExplanation='" + questionExplanation + '\'' +
                ", ordination=" + ordination +
                ", answer='" + answer + '\'' +
                ", answerCheck=" + answerCheck +
                ", answerJustification='" + answerJustification + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }
}
