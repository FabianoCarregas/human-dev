package br.com.alura.humanDev.entities.activities;
import br.com.alura.humanDev.entities.Section;
import static br.com.alura.humanDev.validations.Validation.notNull;
import static br.com.alura.humanDev.validations.Validation.notBlank;
import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;

public abstract class Activity {

    private String title;
    private String code;
    private boolean activityStatus;
    private int ordination;
    private Section section;

    public Activity(String title,
                    String code,
                    Section section) {
        notNull(title);
        notBlank(title);
        this.title = title;
        validUrl(code);
        this.code = code;
        this.section = section;
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