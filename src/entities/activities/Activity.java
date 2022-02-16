package entities.activities;
import entities.Section;
import validations.CodePatternValidation;
import validations.Validation;

public abstract class Activity {

    private String title;
    private String code;
    private boolean activityStatus;
    private int ordination;
    private Section section;

    public Activity(String title,
                    String code,
                    Section section) {
        Validation.notNull(title);
        Validation.notBlank(title);
        this.title = title;
        CodePatternValidation.validUrl(code);
        this.code = code;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public boolean isActivityStatus() {
        return activityStatus;
    }

    public int getOrdination() {
        return ordination;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", activityStatus=" + activityStatus +
                ", ordination=" + ordination +
                ", section=" + section +
                '}';
    }
}