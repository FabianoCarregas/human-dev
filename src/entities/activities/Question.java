package entities.activities;

import entities.Section;
import enums.QuestionType;
import static validations.Validation.notNull;
import static validations.Validation.notBlank;

public class Question extends Activity {

   private String questionDescription;
   private QuestionType questionType;

    public Question(String title,
                    String code,
                    Section section,
                    String questionDescription) {
        super(title, code, section);
        notNull(questionDescription);
        notBlank(questionDescription);
        this.questionDescription = questionDescription;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionDescription='" + questionDescription + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}
