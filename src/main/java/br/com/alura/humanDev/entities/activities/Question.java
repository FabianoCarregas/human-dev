package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;
import br.com.alura.humanDev.enums.QuestionType;

import javax.persistence.*;

import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public class Question extends Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionDescription;

   @Enumerated(EnumType.STRING)
   private QuestionType questionType;

    public Question(String title,
                    String code,
                    Section section,
                    String questionDescription) {
        super(title, code, section);
        notBlankOrNull(questionDescription);
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
