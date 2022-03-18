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
    private String subcategoryDescription;
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
                       Category category_id) {
        notBlankOrNull(name);
        validUrl(code);
        notBlankOrNull(String.valueOf(category_id));
        this.id = id;
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.active = subcategoryStatus;
        this.ordination = ordination;
        this.category = category_id;
    }

    public Subcategory(String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean subcategoryStatus,
                       Category category_id) {
        notBlankOrNull(name);
        validUrl(code);
        notBlankOrNull(String.valueOf(category_id));
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.active = subcategoryStatus;
        this.ordination = ordination;
        this.category = category_id;
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