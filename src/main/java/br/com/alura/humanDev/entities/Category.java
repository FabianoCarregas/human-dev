package br.com.alura.humanDev.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.validations.CodePatternValidation.validColor;
import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @Column(name = "category_description")
    private String categoryDescription;
    @Column(name = "study_guide")
    private String studyGuide;
    private boolean active;
    private Integer order;
    private String icon;
    private String hexaColor;

    @OneToMany(mappedBy = "category")
    List<Subcategory> subcategories = new ArrayList<>();

    public Category() {
    }

    public Category(Long id,
                    String name,
                    String code,
                    Integer order,
                    String categoryDescription,
                    boolean categoryStatus,
                    String icon,
                    String hexaColor) {
        notBlankOrNull(name);
        validUrl(code);
        validColor(hexaColor);
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.active = categoryStatus;
        this.order = order;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    public Category(String name,
                    String code,
                    Integer order,
                    String categoryDescription,
                    boolean categoryStatus,
                    String icon,
                    String hexaColor) {
        notBlankOrNull(name);
        validUrl(code);
        validColor(hexaColor);
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.active = categoryStatus;
        this.order = order;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }
    public Category(Long id,
                    String name,
                    String code,
                    String categoryDescription,
                    String studyGuide,
                    boolean active,
                    Integer order,
                    String icon,
                    String hexaColor) {
        notBlankOrNull(name);
        validUrl(code);
        validColor(hexaColor);
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.studyGuide = studyGuide;
        this.active = active;
        this.order = order;
        this.icon = icon;
        this.hexaColor = hexaColor;
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

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getIcon() {
        return icon;
    }

    public String getHexaColor() {
        return hexaColor;
    }


}
