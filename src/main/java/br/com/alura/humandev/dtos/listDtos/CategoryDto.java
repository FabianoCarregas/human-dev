package br.com.alura.humandev.dtos.listDtos;

import br.com.alura.humandev.entities.Category;

public class CategoryDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;

    @Deprecated
    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.id =  category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
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

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
