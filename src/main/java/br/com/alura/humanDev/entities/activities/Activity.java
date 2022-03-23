package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import javax.persistence.*;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "type")
//@PrimaryKeyJoinColumn
public abstract class Activity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;
    private boolean status;
    private int ordination;

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;

    public Activity() {
    }

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