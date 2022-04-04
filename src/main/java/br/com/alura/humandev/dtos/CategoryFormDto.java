package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CategoryFormDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-z0-9-]+$")
    private String code;
    private String categoryDescription;
    private String studyGuide;
    private boolean active;
    private Integer ordination;
    private String icon;

    @NotEmpty
    @NotNull
    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$")
    private String hexaColor;

    public CategoryFormDto(Long id, String name, String code, String categoryDescription, String studyGuide, boolean active, Integer ordination, String icon, String hexaColor) {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public boolean isActive() {
        return active;
    }

    public Integer getOrdination() {
        return ordination;
    }

    public String getIcon() {
        return icon;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public Category toEntity() {
        return new Category(id, name, code, ordination, categoryDescription, studyGuide, active, icon, hexaColor);
     }

     public static CategoryFormDto toDto(Category category) {
        return new CategoryFormDto(
        category.getId(),
        category.getName(),
        category.getCode(),
        category.getCategoryDescription(),
        category.getStudyGuide(),
        category.isActive(),
        category.getOrdination(),
        category.getIcon(),
        category.getHexaColor());
     }

}
