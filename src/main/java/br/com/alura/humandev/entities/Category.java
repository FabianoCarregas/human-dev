package br.com.alura.humandev.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-z0-9-]+$")
    private String code;

    @Column(name = "category_description")
    private String categoryDescription;

    @Length(min = 50)
    @Column(name = "study_guide")
    private String studyGuide;
    private boolean active = false;
    private Integer ordination;
    private String icon;

    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$")
    private String hexaColor;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Subcategory> subcategories = new ArrayList<>();

    public Category() {
    }

    public Category(String name,
                    String code,
                    Integer ordination,
                    String categoryDescription,
                    boolean active,
                    String icon,
                    String hexaColor) {
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.active = active;
        this.ordination = ordination;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    public int getNumberOfCourses(Subcategory subcategory) {
        int n = subcategory.countCourses();
        return n;
    }

    public void addSubcategory(Subcategory subcategory) {
        this.subcategories.add(subcategory);
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }



    public void toggleStatus() {
        this.active = !isActive();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getIcon() {
        return icon;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public Integer getOrdination() {
        return ordination;
    }

}
