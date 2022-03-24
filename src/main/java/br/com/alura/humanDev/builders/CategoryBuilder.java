package br.com.alura.humanDev.builders;

import br.com.alura.humanDev.entities.Category;

public class CategoryBuilder {

    private String name;
    private String code;
    private Integer ordination;
    private String categoryDescription;
    private boolean active;
    private String icon;
    private String hexaColor;

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CategoryBuilder withCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        return this;
    }

    public CategoryBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public CategoryBuilder withOrdination(Integer ordination) {
        this.ordination = ordination;
        return this;
    }

    public CategoryBuilder withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public CategoryBuilder withHexaColor(String hexaColor) {
        this.hexaColor = hexaColor;
        return this;
    }

    public Category create() {
        return new Category(name, code, ordination, categoryDescription, active, icon, hexaColor);

    }

}
