package entities;

import enums.CourseStatus;
import validations.Validation;

public class Course {
    private Long id;
    public String name;
    private String codeUrl;
    private int courseTimeHours;
    private CourseStatus status;
    private String targetMarket;
    private String instructor;
    private String courseDescription;
    private String developedSkills;
    private Section curseSection;  //onetomany

    public Course(Long id,
                  String name,
                  String codeUrl,
                  int courseTimeHours,
                  CourseStatus status,
                  String targetMarket,
                  String instructor,
                  String courseDescription,
                  String developedSkills) {
        Validation.notNull("name", "The field name can not be null");
        Validation.isValidNumberHours(courseTimeHours, "The video can not be greater than 20 or less than 0");
        Validation.isValidUrl(codeUrl, "This url is not in the correct formatation");
        this.id = id;
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

    public Long getId() {
        return id;
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

    public CourseStatus getStatus() {
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

    public Section getCurseSection() {
        return curseSection;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
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