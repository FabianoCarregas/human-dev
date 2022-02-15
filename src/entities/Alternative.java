package entities;

import entities.activities.Question;

public class Alternative {

    private Long id;
    private String questionExplanation;
    private int ordination;
    private String answer;
    private boolean answerCheck;
    private String answerJustification;
    private String rightAnswer;

    public Alternative(String questionExplanation,
                       int ordination,
                       String answer,
                       boolean answerCheck,
                       String answerJustification,
                       String rightAnswer,
                       Question question) {
        this.questionExplanation = questionExplanation;
        this.ordination = ordination;
        this.answer = answer;
        this.answerCheck = answerCheck;
        this.answerJustification = answerJustification;
        this.rightAnswer = rightAnswer;
    }

    public Alternative(String questionExplanation,
                       boolean answerCheck,
                       Question question) {
        this.questionExplanation = questionExplanation;
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

    public boolean isAnswerCheck() {
        return answerCheck;
    }

    public String getAnswerJustification() {
        return answerJustification;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String toString() {
        return "MultipleChoices{" +
                "questionExplanation='" + questionExplanation + '\'' +
                ", ordination=" + ordination +
                ", answer='" + answer + '\'' +
                ", answerCheck=" + answerCheck +
                ", answerJustification='" + answerJustification + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }
}
