package br.com.alura.humandev.dtos.forms;

import br.com.alura.humandev.entities.Category;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
