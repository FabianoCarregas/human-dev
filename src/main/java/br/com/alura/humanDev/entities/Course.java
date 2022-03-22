package br.com.alura.humanDev.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "SMALLINT",name = "course_time_hours")
    private Integer courseTimeHours;
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

    @OneToMany(mappedBy = "course")
    List<Section> sections = new ArrayList<>();

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
        notBlankOrNull(name);
        validUrl(code);
        validNumberHours(courseTimeHours);
        notBlankOrNull(instructor);
        notBlankOrNull(String.valueOf(subcategory));
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