package br.com.alura.humandev.dtos.forms;

import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;

import javax.validation.constraints.*;

public class CourseFormDto {

    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;

    @Min(1)
    @Max(value = 20, message = "{number.max}")
    @Positive(message = "{number.invalid}")
    private Integer courseTimeHours;
    private boolean active;
    private String targetAudience;

    @NotBlank(message = "{name.invalid}")
    private String instructor;
    private String courseDescription;
    private String developedSkills;
    private Long subcategoryId;

    public CourseFormDto() {
    }

    public CourseFormDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.courseTimeHours = course.getCourseTimeHours();
        this.active = course.isActive();
        this.targetAudience = course.getTargetAudience();
        this.instructor = course.getInstructor();
        this.courseDescription = course.getCourseDescription();
        this.developedSkills = course.getDevelopedSkills();
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

    public String getCourseDescription() {
        return courseDescription;
    }

    public boolean isActive() {
        return active;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCourseTimeHours() {
        return courseTimeHours;
    }

    public void setCourseTimeHours(Integer courseTimeHours) {
        this.courseTimeHours = courseTimeHours;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Course toEntity(Subcategory subcategory) {
        return new Course(id, name, courseTimeHours, code, active, targetAudience, instructor, courseDescription, developedSkills, subcategory);
    }

}
