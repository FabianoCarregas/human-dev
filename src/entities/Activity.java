package entities;

import enums.ActivityStatus;
import validations.Validation;

public class Activity {
    private Long id;
    private String ActivityName;
    private String code;
    private ActivityStatus activityStatus;
    private int ordination;
    private Type type;
    private Question question;
    private Section section;

    public Activity(Long id,
                    String ActivityName,
                    String code,
                    ActivityStatus activityStatus,
                    int ordination, Type type,
                    Question question,
                    Section section) {
        Validation.notNull("name", "The field name can not be null");
        this.id = id;
        this.ActivityName = ActivityName;
        this.code = code;
        this.activityStatus = activityStatus;
        this.ordination = ordination;
        this.type = type;
        this.question = question;
        this.section = section;
    }

    public Activity(String activityName,
                    String code,
                    Section section) {
        ActivityName = activityName;
        this.code = code;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public String getCode() {
        return code;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public int getOrdination() {
        return ordination;
    }

    public Type getType() {
        return type;
    }

    public Question getQuestion() {
        return question;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + ActivityName + '\'' +
                ", code='" + code + '\'' +
                ", activityStatus=" + activityStatus +
                ", ordination=" + ordination +
                ",  \ntype=" + type +
                ",    \nquestion=" + question +
                ",      \nsection=" + section +
                '}';
    }
}