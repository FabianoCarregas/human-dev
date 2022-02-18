package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;
import br.com.alura.humanDev.enums.QuestionType;

import static br.com.alura.humanDev.validations.Validation.notBlank;
import static br.com.alura.humanDev.validations.Validation.notNull;

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
