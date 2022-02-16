package entities;

import validations.CodePatternValidation;
import validations.Validation;

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
        Validation.notNull(name);
        Validation.notBlank(name);
        this.name = name;
        CodePatternValidation.validUrl(code);
        this.code = code;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSubcategoryDescription() {
        return subcategoryDescription;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public boolean isSubcategoryStatus() {
        return subcategoryStatus;
    }

    public int getOrdination() {
        return ordination;
    }

    public Category getCategory() {
        return category;
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