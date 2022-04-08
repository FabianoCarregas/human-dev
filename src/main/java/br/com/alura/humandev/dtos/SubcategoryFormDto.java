package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Subcategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

public class SubcategoryFormDto {

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
    private Category category;

    @Deprecated
    public SubcategoryFormDto() {
    }

    public SubcategoryFormDto(Long id,
                              String name,
                              String code,
                              String categoryDescription,
                              String studyGuide,
                              boolean active,
                              Integer ordination,
                              Category category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.studyGuide = studyGuide;
        this.active = active;
        this.ordination = ordination;
        this.category = category;
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

    public static List<SubcategoryDto> toDto(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDto::new).toList();
    }
    public Subcategory toEntity(Category category) {
        return new Subcategory(id, name , code, categoryDescription, studyGuide, active, ordination, category);
    }

//    public static SubcategoryFormDto toDto(Category category) {
//        return new SubcategoryFormDto(
//            category.getId(),
//            category.getName(),
//            category.getCode(),
//            category.getCategoryDescription(),
//            category.getStudyGuide(),
//            category.isActive(),
//            category.getOrdination())
//    }

}
