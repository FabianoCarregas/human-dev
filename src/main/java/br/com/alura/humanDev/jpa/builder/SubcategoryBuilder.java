package br.com.alura.humanDev.jpa.builder;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;

public class SubcategoryBuilder {

    private String name;
    private String code;
    private Integer ordination;
    private String subcategoryDescription;
    private boolean active;
    private Category category;

    public SubcategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SubcategoryBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public SubcategoryBuilder withSubcategoryDescription(String subcategoryDescription) {
        this.subcategoryDescription = subcategoryDescription;
        return this;
    }

    public SubcategoryBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public SubcategoryBuilder withOrdination(Integer ordination) {
        this.ordination = ordination;
        return this;
    }

    public SubcategoryBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Subcategory create() {
        return new Subcategory(name, code, ordination, subcategoryDescription, active, category);
    }
}
