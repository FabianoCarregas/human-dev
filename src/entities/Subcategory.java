package entities;

import enums.CategoryStatus;
import validations.Validation;

public class Subcategory {
    private Long id;
    private String name;
    private String code;
    private String subcategoryDescription;
    private String studyGuide;
    private CategoryStatus subcategoryStatus;
    private int ordination;
    private Category category;

    public Subcategory(Long id,
                       String name,
                       String code,
                       String subcategoryDescription,
                       String studyGuide,
                       CategoryStatus subcategoryStatus,
                       int ordination,
                       Category category) {
        Validation.notNull("name", "The field name can not be null");
        this.id = id;
        this.name = name;
        this.code = code;
        this.subcategoryDescription = subcategoryDescription;
        this.studyGuide = studyGuide;
        this.subcategoryStatus = subcategoryStatus;
        this.ordination = ordination;
        this.category = category;
    }

    public Subcategory(String name, String code, Category category) {
        this.name = name;
        this.code = code;
        this.category = category;
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

    public String getSubcategoryDescription() {
        return subcategoryDescription;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public CategoryStatus getSubcategoryStatus() {
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
                "id=" + id +
                ", code='" + code + '\'' +
                ", subcategoryDescription='" + subcategoryDescription + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", subcategoryStatus=" + subcategoryStatus +
                ", ordination=" + ordination +
                ",  \ncategory=" + category +
                '}';
    }
}
