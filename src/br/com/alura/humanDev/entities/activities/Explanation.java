package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;
import static br.com.alura.humanDev.validations.Validation.notNull;
import static br.com.alura.humanDev.validations.Validation.notBlank;


public class Explanation extends Activity {

    private String activityExplanation;

    public Explanation(String title,
                       String code,
                       Section section,
                       String activityExplanation) {
        super(title, code, section);
        notNull(activityExplanation);
        notBlank(activityExplanation);
        this.activityExplanation = activityExplanation;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "activityExplanation='" + activityExplanation + '\'' +
                '}';
    }
}
