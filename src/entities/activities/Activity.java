package entities.activities;
import entities.Section;
import validations.CodePatternValidation;
import validations.Validation;

public abstract class Activity {
    private Long id;
    private String title;
    private String code;
    private boolean activityStatus;
    private int ordination;
    private Section section;

    public Activity(String title,
                    String code,
                    boolean activityStatus,
                    int ordination,
                    Section section) {
        Validation.notNull(title, "The field name can not be null");
        Validation.notBlank(title, "The field name can not be empty");
        this.title = title;
        CodePatternValidation.isValidUrl(code, "The code pattern accept only low case characters, numbers and hyphen");
        this.code = code;
        this.activityStatus = activityStatus;
        this.ordination = ordination;
        this.section = section;
    }

    public Activity(String title,
                    String code,
                    Section section) {
        Validation.notNull(title, "The field name can not be null");
        Validation.notBlank(title, "The field name can not be empty");
        this.title = title;
        CodePatternValidation.isValidUrl(code, "The code pattern accept only low case characters, numbers and hyphen");
        this.code = code;
        this.section = section;
    }

    public Long getId() {
        return id;
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
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", activityStatus=" + activityStatus +
                ", ordination=" + ordination +
                ", section=" + section +
                '}';
    }
}