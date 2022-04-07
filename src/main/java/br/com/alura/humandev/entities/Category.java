package br.com.alura.humandev.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;
    private String categoryDescription;
    private String studyGuide;
    private boolean active;

    @Positive(message = "{number.invalid}")
    private Integer ordination;
    private String icon;

    @NotBlank
    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$", message = "{color.invalid}")
    private String hexaColor;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Subcategory> subcategories = new ArrayList<>();

    @Deprecated
    public Category() {
    }

    public Category(String name,
                    String code,
                    Integer ordination,
                    String categoryDescription,
                    String studyGuide,
                    boolean active,
                    String icon,
                    String hexaColor) {
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.studyGuide = studyGuide;
        this.active = active;
        this.ordination = ordination;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    public Category(Long id,
                    String name,
                    String code,
                    String categoryDescription,
                    String studyGuide,
                    boolean active,
                    Integer ordination,
                    String icon,
                    String hexaColor) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.studyGuide = studyGuide;
        this.active = active;
        this.ordination = ordination;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    public void addSubcategory(Subcategory subcategory) {
        this.subcategories.add(subcategory);
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
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
