package entities;

import validations.Validation;

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
        Validation.notNull(name);
        Validation.notBlank(name);
        this.name = name;
        this.codeUrl= codeUrl;
        Validation.validNumberHours(courseTimeHours);
        this.courseTimeHours = courseTime;
        Validation.notNull(instructor);
        Validation.notBlank(instructor);
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public int getCourseTimeHours() {
        return courseTimeHours;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getDevelopedSkills() {
        return developedSkills;
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