package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.*;

public class Course {

    private Long id;
    private String name;
    private String codeUrl;
    private Integer courseTimeHours;
    private boolean status;
    private String targetAudience;
    private String instructor;
    private String courseDescription;
    private String developedSkills;
    private Subcategory subcategory;

    public Course(String name,
                  String codeUrl,
                  Integer courseTimeHours,
                  boolean status,
                  String targetAudience,
                  String instructor,
                  String courseDescription,
                  String developedSkills,
                  Subcategory subcategory) {
        notBlankOrNull(name);
        validUrl(codeUrl);
        validNumberHours(courseTimeHours);
        notBlankOrNull(instructor);
        notBlankOrNull(String.valueOf(subcategory));
        this.name = name;
        this.codeUrl = codeUrl;
        this.courseTimeHours = courseTimeHours;
        this.status = status;
        this.targetAudience = targetAudience;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public Course(String name, String codeUrl, Integer courseTimeHours, String instructor) {
        this.name = name;
        this.codeUrl = codeUrl;
        this.courseTimeHours = courseTimeHours;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public Integer getCourseTimeHours() {
        return courseTimeHours;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public boolean isStatus() {
        return status;
    }

    public String getInstructor() {
        return instructor;
    }

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