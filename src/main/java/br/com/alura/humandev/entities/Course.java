package br.com.alura.humandev.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @Positive(message = "{number.invalid}")
    private Integer courseTimeHours;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;
    private boolean status;
    private String targetAudience;
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
                  boolean status,
                  String targetAudience,
                  String instructor,
                  String courseDescription,
                  String developedSkills,
                  Subcategory subcategory) {
        this.name = name;
        this.code = code;
        this.courseTimeHours = courseTimeHours;
        this.status = status;
        this.targetAudience = targetAudience;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
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

    public boolean isStatus() {
        return status;
    }

    public String getInstructor() {
        return instructor;
    }

}