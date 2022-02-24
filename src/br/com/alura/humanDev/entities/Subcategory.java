package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlank;
import static br.com.alura.humanDev.validations.Validation.notNull;

public class Subcategory {

    private String name;
    private String code;
    private String subcategoryDescription;
    private String studyGuide;
    private boolean subcategoryStatus;
    private Integer ordination;
    private Category category;

    public Subcategory(String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean subcategoryStatus,
                       Category category) {
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.subcategoryStatus = subcategoryStatus;
        this.ordination = ordination;
        notNull(String.valueOf(category));
        notBlank(String.valueOf(category));
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

    public boolean isSubcategoryStatus() {
        return subcategoryStatus;
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
                "   \"subcategoryStatus\" = " + subcategoryStatus + ", \n" +
                "   \"ordination\" = " + ordination + ", \n" +
                "         \"category\" = \"" + category + "; \n" +
                '}';
    }

}