package br.com.alura.humandev.entities;

import br.com.alura.humandev.entities.activities.Question;

import javax.persistence.*;

@Entity
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question_explanation")
    private String questionExplanation;
    private int ordination;
    private String answer;
    @Column(name = "answer_check")
    private boolean answerCheck;
    @Column(name = "answer_justification")
    private String answerJustification;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Alternative() {
    }

    public Alternative(String questionExplanation,
                       String answer,
                       boolean answerCheck,
                       Question question) {
        this.questionExplanation = questionExplanation;
        this.answer = answer;
        this.answerCheck = answerCheck;
        this.question = question;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "questionExplanation='" + questionExplanation + '\'' +
                ", ordination=" + ordination +
                ", answer='" + answer + '\'' +
                ", answerCheck=" + answerCheck +
                ", answerJustification='" + answerJustification + '\'' +
                ", rightAnswer='" + answerCheck + '\'' +
                '}';
    }

}
