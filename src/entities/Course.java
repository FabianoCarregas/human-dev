package entities;

import validations.Validation;

public class Course {
    private Long id;
    public String name;
    private String codeUrl;
    private int courseTimeHours;
    private boolean status;
    private String targetMarket;
    private String instructor;
    private String courseDescription;
    private String developedSkills;

    public Course(String name,
                  String codeUrl,
                  int courseTimeHours,
                  boolean status,
                  String targetMarket,
                  String instructor,
                  String courseDescription,
                  String developedSkills) {
        Validation.notNull("name", "The field name can not be null");
        Validation.isValidNumberHours(courseTimeHours, "The video can not be greater than 20 or less than 0");
        //Validation.isValidUrl(codeUrl);
        this.name = name;
        this.codeUrl = codeUrl;
        this.courseTimeHours = courseTimeHours;
        this.status = status;
        this.targetMarket = targetMarket;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
        this.developedSkills = developedSkills;
    }

    public Course(String name,
                  String codeUrl,
                  int courseTime,
                  String instructor) {
        this.name = name;
        this.codeUrl = codeUrl;
        this.courseTimeHours = courseTime;
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

    public String getTargetMarket() {
        return targetMarket;
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
                ", name='" + name + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                ", courseTime=" + courseTimeHours +
                ", status=" + status +
                ", targetMarket='" + targetMarket + '\'' +
                ", instructor='" + instructor + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", developedSkills='" + developedSkills +
                '}';
    }
}