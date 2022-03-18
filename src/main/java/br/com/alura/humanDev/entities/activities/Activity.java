package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public abstract class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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