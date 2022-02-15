package entities;

import validations.Validation;

public class Section {

    private Long id;
    private String name;
    private String code;
    private int SectionOrdination;
    private boolean sectionStatus;
    private boolean testStatus;
    private Course course;

    public Section(String name,
                   String code,
                   int sectionOrdination,
                   boolean sectionStatus,
                   boolean testStatus,
                   Course course) {
        Validation.notNull("name", "The field name can not be null");
        this.name = name;
        this.code = code;
        SectionOrdination = sectionOrdination;
        this.sectionStatus = sectionStatus;
        this.testStatus = testStatus;
        this.course = course;
    }

    public Section(String name,
                   String code,
                   Course course) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", SectionOrdination=" + SectionOrdination +
                ", sectionStatus=" + sectionStatus +
                ", testStatus=" + testStatus +
                ",  \ncourse=" + course +
                '}';
    }
}
