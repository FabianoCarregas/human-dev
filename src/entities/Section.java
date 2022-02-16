package entities;

import validations.CodePatternValidation;
import validations.Validation;

public class Section {

    private String name;
    private String code;
    private int SectionOrdination;
    private boolean sectionStatus;
    private boolean testStatus;
    private Course course;

    public Section(String name,
                   String code,
                   Course course) {
        Validation.notNull(name);
        Validation.notBlank(name);
        this.name = name;
        CodePatternValidation.validUrl(code);
        this.code = code;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getSectionOrdination() {
        return SectionOrdination;
    }

    public boolean isSectionStatus() {
        return sectionStatus;
    }

    public boolean isTestStatus() {
        return testStatus;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", SectionOrdination=" + SectionOrdination +
                ", sectionStatus=" + sectionStatus +
                ", testStatus=" + testStatus +
                ", course=" + course +
                '}';
    }
}
