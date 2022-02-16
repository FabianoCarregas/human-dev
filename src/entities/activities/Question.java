package entities.activities;

import entities.Section;
import enums.QuestionType;
import validations.Validation;

public class Question extends Activity {

   private Long id;
   private String questionDescription;
   private QuestionType questionType;

    public Question(String title,
                    String code,
                    Section section,
                    String questionDescription) {
        super(title, code, section);
        Validation.notNull(questionDescription, "The field name can not be null");
        Validation.notBlank(questionDescription, "The field name can not be empty");
        this.questionDescription = questionDescription;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionDescription='" + questionDescription + '\'' +
                '}';
    }
}
