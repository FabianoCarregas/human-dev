package entities.activities;

import entities.Section;
import validations.Validation;

public class Explanation extends Activity {

    private String activityExplanation;

    public Explanation(String title,
                       String code,
                       Section section,
                       String activityExplanation) {
        super(title, code, section);
        Validation.notNull(activityExplanation);
        Validation.notBlank(activityExplanation);
        this.activityExplanation = activityExplanation;
    }

    public String getActivityExplanation() {
        return activityExplanation;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "activityExplanation='" + activityExplanation + '\'' +
                '}';
    }
}
