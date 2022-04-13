package br.com.alura.humandev.dtos.forms;

import br.com.alura.humandev.entities.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class CategoryFormDto {

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

    @Deprecated
    public CategoryFormDto() {
    }

    public CategoryFormDto(Long id,
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setOrdination(Integer ordination) {
        this.ordination = ordination;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setHexaColor(String hexaColor) {
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
        return new Category(id, name , code, categoryDescription, studyGuide,active,ordination , icon, hexaColor);
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
