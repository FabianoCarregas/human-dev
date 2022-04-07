package br.com.alura.humandev.entities.activities;


import br.com.alura.humandev.entities.Alternative;
import br.com.alura.humandev.entities.Section;
import br.com.alura.humandev.enums.QuestionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question extends Activity {

    private Long id;
    private String questionDescription;

    @OneToMany(mappedBy = "question")
    List<Alternative> alternatives = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    public Question() {
    }

    public Question(String title,
                    String code,
                    Section section,
                    String questionDescription) {
        super(title, code, section);
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
