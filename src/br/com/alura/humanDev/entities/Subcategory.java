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
    private int ordination;
    private Category category;

    public Subcategory(String name,
                       String code,
                       Category category) {
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", subcategoryDescription='" + subcategoryDescription + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", subcategoryStatus=" + subcategoryStatus +
                ", ordination=" + ordination +
                ", category=" + category +
                '}';
    }
}