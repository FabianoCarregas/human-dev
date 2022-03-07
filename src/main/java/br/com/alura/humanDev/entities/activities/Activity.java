package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public abstract class Activity {

    private Long id;
    private String title;
    private String code;
    private boolean status;
    private int ordination;
    private Section section;

    public Activity(String title,
                    String code,
                    Section section) {
        notBlankOrNull(title);
        validUrl(code);
        this.title = title;
        this.code = code;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", activityStatus=" + status +
                ", ordination=" + ordination +
                ", section=" + section +
                '}';
    }
}