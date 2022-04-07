package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Category;

public class CategoryDto {

    private String name;
    private String code;
    private boolean active;

    @Deprecated
    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
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

}
