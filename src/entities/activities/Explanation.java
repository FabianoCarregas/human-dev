package entities.activities;

import entities.Section;
import static validations.Validation.notNull;
import static validations.Validation.notBlank;


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
