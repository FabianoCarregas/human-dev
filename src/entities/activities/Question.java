package entities;

import enums.DoubleChoiceQuestion;
import validations.Validation;

public class Question {

    private Long id;
    private String questionDescription;
    private String simpleQuestion;
    private DoubleChoiceQuestion doubleChoice;
    private MultipleChoices multipleChoices;

    public Question(Long id,
                    String questionDescription,
                    String simpleQuestion,
                    DoubleChoiceQuestion doubleChoice,
                    MultipleChoices multipleChoices) {
        Validation.notNull("name", "The field name can not be null");
        this.id = id;
        this.questionDescription = questionDescription;
        this.simpleQuestion = simpleQuestion;
        this.doubleChoice = doubleChoice;
        this.multipleChoices = multipleChoices;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public String getSimpleQuestion() {
        return simpleQuestion;
    }

    public DoubleChoiceQuestion getDoubleChoice() {
        return doubleChoice;
    }

    public MultipleChoices getMultipleChoices() {
        return multipleChoices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionDescription='" + questionDescription + '\'' +
                ", simpleQuestion='" + simpleQuestion + '\'' +
                ", doubleChoice=" + doubleChoice +
                ", multipleChoices=" + multipleChoices +
                '}';
    }
}
