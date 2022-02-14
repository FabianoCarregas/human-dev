package entities;

import enums.SectionStatus;
import enums.TestStatus;
import validations.Validation;

public class Section {

    private Long id;
    private String name;
    private String code;
    private int SectionOrdination;
    private SectionStatus sectionStatus;
    private TestStatus testStatus;
    private Course course;      // manytoone

    public Section(Long id,
                   String name,
                   String code,
                   int sectionOrdination,
                   SectionStatus sectionStatus,
                   TestStatus testStatus,
                   Course course) {
        Validation.notNull("name", "The field name can not be null");
        this.id = id;
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

    public Long getId() {
        return id;
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

    public SectionStatus getSectionStatus() {
        return sectionStatus;
    }

    public TestStatus getTestStatus() {
        return testStatus;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", SectionOrdination=" + SectionOrdination +
                ", sectionStatus=" + sectionStatus +
                ", testStatus=" + testStatus +
                ",  \ncourse=" + course +
                '}';
    }
}
