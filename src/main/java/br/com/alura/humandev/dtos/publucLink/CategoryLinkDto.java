package br.com.alura.humandev.dtos.publucLink;

import br.com.alura.humandev.entities.Category;

import java.util.List;

public class CategoryLinkDto {

    private String name;
    private String icon;
    private List<SubcategoryLinkDto> subcategoryLinkDtos;

    public CategoryLinkDto() {
    }

    public CategoryLinkDto(Category category) {
        this.name = category.getName();
        this.icon = category.getIcon();
        this.subcategoryLinkDtos = category.getSubcategories().stream().map(SubcategoryLinkDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public List<SubcategoryLinkDto> getSubcategoryLinkDtos() {
        return subcategoryLinkDtos;
    }
}
