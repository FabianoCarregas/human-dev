package br.com.alura.humandev.entities;

import br.com.alura.humandev.entities.activities.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionExplanation;
    private int ordination;
    private String answer;
    private boolean answerCheck;
    private String answerJustification;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

}
