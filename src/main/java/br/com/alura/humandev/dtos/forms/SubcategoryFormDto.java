package br.com.alura.humandev.dtos.forms;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
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

    public SubcategoryFormDto(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.subcategoryDescription = subcategory.getSubcategoryDescription();
        this.studyGuide = subcategory.getStudyGuide();
        this.active = subcategory.isActive();
        this.ordination = subcategory.getOrdination();
    }

    public Subcategory toEntity(Category category) {
        return new Subcategory(id, name , code, subcategoryDescription, studyGuide, active, ordination, category);
    }

}
