package entities;

import enums.answerCheck;

public class MultipleChoices {

    private Long id;
    private String questionExplanation;
    private int ordination;
    private String answer;
    private answerCheck answerCheck;
    private String answerJustification;
    private String answerValidator;

    public MultipleChoices(Long id,
                           String questionExplanation,
                           int ordination,
                           String answer,
                           String answerJustification,
                           String answerValidator) {
        this.id = id;
        this.questionExplanation = questionExplanation;
        this.ordination = ordination;
        this.answer = answer;
        this.answerCheck = answerCheck;
        this.answerJustification = answerJustification;
        this.answerValidator = answerValidator;
    }

    public MultipleChoices(String questionExplanation,
                           String answer,
                           enums.answerCheck answerCheck) {
        this.questionExplanation = questionExplanation;
        this.answer = answer;
        this.answerCheck = answerCheck;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public int getOrdination() {
        return ordination;
    }

    public String getAnswer() {
        return answer;
    }

    public enums.answerCheck getAnswerCheck() {
        return answerCheck;
    }

    public String getAnswerJustification() {
        return answerJustification;
    }

    public String getAnswerValidator() {
        return answerValidator;
    }

    @Override
    public String toString() {
        return "MultipleChoices{" +
                "id=" + id +
                ", questionExplanation='" + questionExplanation + '\'' +
                ", ordination=" + ordination +
                ", answer='" + answer + '\'' +
                ", checkAnswer=" + answerCheck +
                ", answerJustification='" + answerJustification + '\'' +
                ", answerValidator='" + answerValidator + '\'' +
                '}';
    }
}
