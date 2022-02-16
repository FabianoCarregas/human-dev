package entities;

import validations.Validation;
import static validations.Validation.notNull;
import static validations.Validation.notBlank;
import static validations.Validation.validNumberHours;

public class Course {

    public String name;
    private String codeUrl;
    private int courseTimeHours;
    private boolean status;
    private String targetAudience;
    private String instructor;
    private String courseDescription;
    private String developedSkills;

    public Course(String name,
                  String codeUrl,
                  int courseTime,
                  String instructor) {
        notNull(name);
        notBlank(name);
        this.name = name;
        this.codeUrl= codeUrl;
        validNumberHours(courseTimeHours);
        this.courseTimeHours = courseTime;
        notNull(instructor);
        notBlank(instructor);
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                ", courseTimeHours=" + courseTimeHours +
                ", status=" + status +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructor='" + instructor + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                '}';
    }
}