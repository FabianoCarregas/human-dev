package entities;

import static validations.Validation.notNull;
import static validations.Validation.notBlank;
import static validations.CodePatternValidation.validUrl;

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