package br.com.alura.humandev.dtos.listDtos;
import br.com.alura.humandev.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;
    private String icon;
    private List<SubcategoryDto> subcategoriesDto;

    public CategoryDto(Category category) {
        this.id =  category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.icon = category.getIcon();
        this.subcategoriesDto = SubcategoryDto.toDto(category.getSubcategories());
    }

}
