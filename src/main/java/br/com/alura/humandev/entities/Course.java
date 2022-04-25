package br.com.alura.humandev.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @Min(1)
    @Max(value = 20, message = "{number.max}")
    @Positive(message = "{number.invalid}")
    private Integer courseTimeHours;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;
    private boolean active = true;
    private String targetAudience;

    @NotBlank(message = "{name.invalid}")
    private String instructor;
    private String courseDescription;
    private String developedSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subcategory subcategory;

    @Deprecated
    public Course() {
    }

    public Course(String name,
                  String code,
                  Integer courseTimeHours,
                  boolean active,
                  String targetAudience,
                  String instructor,
                  String courseDescription,
                  String developedSkills,
                  Subcategory subcategory) {
        this.name = name;
        this.code = code;
        this.courseTimeHours = courseTimeHours;
        this.active = active;
        this.targetAudience = targetAudience;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public Course(Long id,
                  String name,
                  Integer courseTimeHours,
                  String code,
                  boolean active,
                  String targetAudience,
                  String instructor,
                  String courseDescription,
                  String developedSkills,
                  Subcategory subcategory) {
        this.id = id;
        this.name = name;
        this.courseTimeHours = courseTimeHours;
        this.code = code;
        this.active = active;
        this.targetAudience = targetAudience;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public String getDevelopedSkills() {
        return developedSkills;
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

    public Integer getCourseTimeHours() {
        return courseTimeHours;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public String getInstructor() {
        return instructor;
    }

}