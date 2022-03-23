package br.com.alura.humanDev.jpa.builder;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

public class CourseBuilder {

    private String name;
    private String code;
    private Integer courseTimeHours;
    private boolean status;
    private String targetAudience;
    private String instructor;
    private String courseDescription;
    private String developedSkills;
    private Subcategory subcategory;

    public void setCode(String code) {
        this.code = code;
    }

    public CourseBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CourseBuilder withCourseTimeHours(Integer courseTimeHours) {
        this.courseTimeHours = courseTimeHours;
        return this;
    }

    public CourseBuilder withStatus(boolean status) {
        this.status = status;
        return this;
    }

    public CourseBuilder withTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
        return this;
    }

    public CourseBuilder withIntructor(String instructor) {
        this.instructor = instructor;
        return this;

    }

    public CourseBuilder withCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
        return this;
    }

    public CourseBuilder withDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
        return this;
    }

    public CourseBuilder withSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
        return this;
    }

    public Course create() {
        return new Course(name, code, courseTimeHours, status, targetAudience, instructor, courseDescription, developedSkills, subcategory);
    }

}
