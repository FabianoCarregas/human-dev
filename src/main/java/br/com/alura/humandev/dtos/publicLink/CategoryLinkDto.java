package br.com.alura.humandev.dtos.publicLink;

import br.com.alura.humandev.entities.Category;

import java.util.List;

public class CategoryLinkDto {

    private String name;
    private String code;
    private String icon;
    private List<SubcategoryLinkDto> subcategoryLinkDtos;

    public CategoryLinkDto() {
    }

    public CategoryLinkDto(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.icon = category.getIcon();
        this.subcategoryLinkDtos = category.getSubcategories()
                .stream().filter(s -> s.isActive()).map(SubcategoryLinkDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getIcon() {
        return icon;
    }

    public List<SubcategoryLinkDto> getSubcategoryLinkDtos() {
        return subcategoryLinkDtos;
    }
}
