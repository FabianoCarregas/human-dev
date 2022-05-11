package br.com.alura.humandev.dtos.listDtos;
import br.com.alura.humandev.entities.Subcategory;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;

    public SubcategoryDto(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.active = subcategory.isActive();
    }

    public static List<SubcategoryDto> toDto(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDto::new).toList();
    }

}
