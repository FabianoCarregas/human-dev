package entities;

import entities.activities.Question;
import validations.Validation;

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
        Validation.notNull(questionExplanation);
        Validation.notBlank(questionExplanation);
        this.questionExplanation = questionExplanation;
        this.answerCheck = answerCheck;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
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
