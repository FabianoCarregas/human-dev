package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Category;

import java.util.List;

public class CategoryDto {

    private String name;
    private String code;
    private boolean active;
    private List<SubcategoryDtoApi> subcategory;

    public CategoryDto(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.subcategory = SubcategoryDtoApi.toDto(category.getSubcategories());
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public List<SubcategoryDtoApi> getSubcategory() {
        return subcategory;
    }

    public List<SubcategoryDtoApi> getSubcategoryApis() {
        return subcategory;
    }
}
