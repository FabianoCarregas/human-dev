package br.com.alura.humandev.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;
    private String subcategoryDescription;
    private String studyGuide;
    private boolean active;

    @Positive(message = "{number.invalid}")
    private Integer ordination;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    List<Course> courses = new ArrayList<>();

    @Deprecated
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
    public Subcategory(Long id,
                       String name,
                       String code,
                       String subcategoryDescription,
                       String studyGuide,
                       boolean active,
                       Integer ordination,
                       Category category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.studyGuide = studyGuide;
        this.active = active;
        this.ordination = ordination;
        this.category = category;
    }

    public void deactivate() {
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public String getStudyGuide() {
        return studyGuide;
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

    public List<Course> getCourses() {
        return courses;
    }

}