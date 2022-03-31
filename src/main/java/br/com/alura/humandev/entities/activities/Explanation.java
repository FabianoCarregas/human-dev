package br.com.alura.humandev.entities.activities;

import br.com.alura.humandev.entities.Section;

import javax.persistence.Column;
import javax.persistence.Entity;

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
        this.activityExplanation = activityExplanation;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "activityExplanation='" + activityExplanation + '\'' +
                '}';
    }

}
