package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public class Section {

    private Long id;
    private String name;
    private String code;
    private int ordination;
    private boolean active;
    private boolean testStatus;
    private Course course;

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
