package br.com.alura.humandev.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Category {

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

    public void deactivate() {
        this.active = false;
    }

    public void addSubcategory(Subcategory subcategory) {
        this.subcategories.add(subcategory);
    }

}
