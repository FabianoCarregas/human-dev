package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import javax.persistence.*;

import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public class Explanation extends Activity {

    private Long id;
    @Column(name = "activity_explanation")
    private String activityExplanation;

    public Explanation() {
    }

    public Explanation(String title,
                       String code,
                       Section section,
                       String activityExplanation) {
        super(title, code, section);
        notBlankOrNull(activityExplanation);
        this.activityExplanation = activityExplanation;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "activityExplanation='" + activityExplanation + '\'' +
                '}';
    }

}
