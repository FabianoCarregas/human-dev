package br.com.alura.humanDev.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @Column(columnDefinition = "TEXT", name = "subcategory_description")
    private String subcategoryDescription;

    @Column(name = "study_guide")
    private String studyGuide;
    private boolean active;
    private Integer ordination;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "subcategory")
    List<Course> courses = new ArrayList<>();

    public Subcategory() {
    }

    public Subcategory(Long id,
                       String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean subcategoryStatus,
                       Category category) {
        notBlankOrNull(name);
        validUrl(code);
        notBlankOrNull(String.valueOf(category));
        this.id = id;
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.active = subcategoryStatus;
        this.ordination = ordination;
        this.category = category;
    }

    public Subcategory(String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean subcategoryStatus,
                       Category category) {
        notBlankOrNull(name);
        validUrl(code);
        notBlankOrNull(String.valueOf(category));
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.active = subcategoryStatus;
        this.ordination = ordination;
        this.category = category;
    }

    public Subcategory(Long id, String name, String code, String subcategoryDescription, String studyGuide, boolean active, Integer ordination, Category category) {
        notBlankOrNull(name);
        validUrl(code);
        notBlankOrNull(String.valueOf(category));
        this.id = id;
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.studyGuide = studyGuide;
        this.active = active;
        this.ordination = ordination;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSubcategoryDescription() {
        return subcategoryDescription;
    }

    public boolean isActive() {
        return active;
    }

    public Integer getOrdination() {
        return ordination;
    }

    public Category getCategory() {
        return category;
    }

}