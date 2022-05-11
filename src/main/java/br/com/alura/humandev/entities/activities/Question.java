package br.com.alura.humandev.entities.activities;


import br.com.alura.humandev.entities.Alternative;
import br.com.alura.humandev.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Question extends Activity {

    private Long id;
    private String questionDescription;

    @OneToMany(mappedBy = "question")
    List<Alternative> alternatives = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

}
