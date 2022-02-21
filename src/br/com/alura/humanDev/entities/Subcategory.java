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
    private String category;

    public Subcategory(String name,
                       String code,
                       Category category) {
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
        this.category = String.valueOf(category);
    }

    public Subcategory(String name,
                       String code,
                       Integer ordination,
                       String subcategoryDescription,
                       boolean subcategoryStatus,
                       String category) {
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.subcategoryStatus = subcategoryStatus;
        this.ordination = ordination;
        this.category = category;
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
                "   \"category\" = \"" + category + "; \n" +
                '}';
    }
}