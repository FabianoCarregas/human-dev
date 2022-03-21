package br.com.alura.humanDev.entities;

import br.com.alura.humanDev.entities.activities.Activity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private int ordination;
    private boolean active;
    @Column(name = "test_status")
    private boolean testStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @OneToMany(mappedBy = "section")
    List<Activity> activities = new ArrayList<>();

    public Section() {
    }

    public Section(String name,
                   String code,
                   Course course) {
        notBlankOrNull(name);
        validUrl(code);
        this.name = name;
        this.code = code;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", SectionOrdination=" + ordination +
                ", sectionStatus=" + active +
                ", testStatus=" + testStatus +
                ", course=" + course +
                '}';
    }

}
