package br.com.alura.humandev.dtos.forms;

import br.com.alura.humandev.dtos.listDtos.SubcategoryDto;
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
    private String subcategoryDescription;
    private String studyGuide;
    private boolean active;

    @Positive(message = "{number.invalid}")
    private Integer ordination;
    private Long categoryId;

    public SubcategoryFormDto() {
    }

    public SubcategoryFormDto(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.subcategoryDescription = subcategory.getSubcategoryDescription();
        this.studyGuide = subcategory.getStudyGuide();
        this.active = subcategory.isActive();
        this.ordination = subcategory.getOrdination();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public void setSubcategoryDescription(String subcategoryDescription) {
        this.subcategoryDescription = subcategoryDescription;
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

    public String getSubcategoryDescription() {
        return subcategoryDescription;
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

    public static List<SubcategoryDto> toDtoList(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDto::new).toList();
    }

    public Subcategory toEntity(Category category) {
        return new Subcategory(id, name , code, subcategoryDescription, studyGuide, active, ordination, category);
    }

    public static SubcategoryFormDto toDto(Subcategory subcategory) {
        return new SubcategoryFormDto(subcategory);
    }

}
