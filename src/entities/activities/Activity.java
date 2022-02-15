package entities.activities;
import entities.Section;

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
        this.title = title;
        this.code = code;
        this.activityStatus = activityStatus;
        this.ordination = ordination;
        this.section = section;
    }

    public Activity(String title,
                    String code,
                    Section section) {
        this.title = title;
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