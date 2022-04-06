package br.com.alura.humandev.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "the name should not be null or empty")
    private String name;

    @Positive(message = "Course hours must not be null")
    @Column(columnDefinition = "SMALLINT",name = "course_time_hours")
    private Integer courseTimeHours;

    @NotBlank(message = "Code can't be null")
    @Pattern(regexp = "^[a-z0-9-]+$", message = "The code must not be with space or special characters")
    private String code;
    private boolean status;

    @Column(columnDefinition = "TEXT", name = "target_audience")
    private String targetAudience;

    private String instructor;
    @Column(columnDefinition = "TEXT", name = "course_description")
    private String courseDescription;

    @Column(columnDefinition = "TEXT", name = "developed_skills")
    private String developedSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subcategory subcategory;

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