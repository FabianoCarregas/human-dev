package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public class Explanation extends Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activityExplanation;

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
