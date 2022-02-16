package entities;

import static validations.Validation.notNull;
import static validations.Validation.notBlank;
import static validations.CodePatternValidation.validUrl;

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
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
        this.course = course;
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
