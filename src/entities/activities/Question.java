package entities.activities;

import entities.Section;
import enums.QuestionType;

public class Question extends Activity {

   private Long id;
   private String questionDescription;
   private QuestionType questionType;

    public Question(String title,
                    String code,
                    Section section,
                    String questionDescription) {
        super(title, code, section);
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
