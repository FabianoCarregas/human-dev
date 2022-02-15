package entities.activities;

import entities.Section;

public class Explanation extends Activity {

    private Long id;
    private String activityExplanation;

    public Explanation(String title,
                       String code,
                       Section section,
                       String activityExplanation) {
        super(title, code, section);
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
