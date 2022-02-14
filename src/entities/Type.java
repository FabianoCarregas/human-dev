package entities;

import validations.Validation;

public class Type {

    private Long id;
    private String activityExplanation;
    private Question activityQuestion;
    private Video video;

    public Type(Long id,
                String activityExplanation,
                Question activityQuestion,
                Video video) {
        Validation.notNull("name", "The field name can not be null");
        this.id = id;
        this.activityExplanation = activityExplanation;
        this.activityQuestion = activityQuestion;
        this.video = video;
    }


    public Long getId() {
        return id;
    }

    public String getActivityExplanation() {
        return activityExplanation;
    }

    public Question getActivityQuestion() {
        return activityQuestion;
    }

    public Video getVideo() {
        return video;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", activityExplanation='" + activityExplanation + '\'' +
                ",  \nactivityQuestion=" + activityQuestion +
                ",      \nvideo=" + video +
                '}';
    }
}


