package br.com.alura.humandev.dtos.listDtos;

import br.com.alura.humandev.entities.Subcategory;

public class SubcategoryDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;

    @Deprecated
    public SubcategoryDto() {
    }

    public SubcategoryDto(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.active = subcategory.isActive();
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