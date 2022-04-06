package br.com.alura.humandev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    List<Course> courses = new ArrayList<>();

    public Subcategory() {
    }

    public Subcategory(String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean active,
                       Category category) {
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.active = active;
        this.ordination = ordination;
        this.category = category;
        this.category.addSubcategory(this);
    }

    public List<Course> getCourses() {
        return courses;
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