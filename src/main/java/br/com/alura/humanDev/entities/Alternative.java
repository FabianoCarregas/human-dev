package br.com.alura.humanDev.entities;

import br.com.alura.humanDev.entities.activities.Question;

import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public class Alternative {

    private Long id;
    private String questionExplanation;
    private int ordination;
    private String answer;
    private boolean answerCheck;
    private String answerJustification;
    private Question question;

    public Alternative(String questionExplanation,
                       String answer,
                       boolean answerCheck,
                       Question question) {
        notBlankOrNull(questionExplanation);
        this.questionExplanation = questionExplanation;
        this.answer = answer;
        this.answerCheck = answerCheck;
        this.question = question;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "questionExplanation='" + questionExplanation + '\'' +
                ", ordination=" + ordination +
                ", answer='" + answer + '\'' +
                ", answerCheck=" + answerCheck +
                ", answerJustification='" + answerJustification + '\'' +
                ", rightAnswer='" + answerCheck + '\'' +
                '}';
    }
}
