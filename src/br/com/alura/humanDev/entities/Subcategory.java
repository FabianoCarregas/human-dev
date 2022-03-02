package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public class Subcategory {

    private String name;
    private String code;
    private String subcategoryDescription;
    private String studyGuide;
    private boolean active;
    private Integer ordination;
    private Category category;

    public Subcategory(String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean subcategoryStatus,
                       Category category) {
        notBlankOrNull(name);
        validUrl(code);
        notBlankOrNull(String.valueOf(category));
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.active = subcategoryStatus;
        this.ordination = ordination;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSubcategoryDescription() {
        return subcategoryDescription;
    }

    public boolean isActive() {
        return active;
    }

    public Integer getOrdination() {
        return ordination;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Subcategory {\n" +
                "   \"name\" = \"" + name + "\", \n" +
                "   \"code\" = \"" + code + "\", \n" +
                "   \"subcategoryDescription\" = \"" + subcategoryDescription + "\", \n" +
                "   \"studyGuide\" = \"" + studyGuide + "\", \n" +
                "   \"subcategoryStatus\" = " + active + ", \n" +
                "   \"ordination\" = " + ordination + ", \n" +
                "         \"category\" = \"" + category + "; \n" +
                '}';
    }

}