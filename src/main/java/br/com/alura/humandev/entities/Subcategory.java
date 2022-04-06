package br.com.alura.humandev.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subcategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be null or empty")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$")
    private String code;

    @Column(columnDefinition = "TEXT", name = "subcategory_description")
    private String subcategoryDescription;

    @Column(name = "study_guide")
    private String studyGuide;
    private boolean active;

    @Positive
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