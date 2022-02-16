package entities;

import validations.CodePatternValidation;
import validations.Validation;

import java.io.File;

public class Category {

    private Long id;
    private String name;
    private String code;
    private String categoryDescription;
    private String studyGuide;
    private boolean categoryStatus;
    private int order;
    private File icon;
    private String hexaColor;

    public Category(String name,
                    String code,
                    String categoryDescription,
                    String studyGuide,
                    boolean categoryStatus,
                    int order,
                    File icon,
                    String hexaColor) {
        Validation.notNull(name, "The field name can not be null");
        Validation.notBlank(name, "The field name can not be empty");
        this.name = name;
        CodePatternValidation.isValidUrl(code, "The code pattern accept only low case characters, numbers and hyphen");
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.studyGuide = studyGuide;
        this.categoryStatus = categoryStatus;
        this.order = order;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    public Category(String name,
                    String code) {
        Validation.notNull(name, "The field name can not be null");
        Validation.notBlank(name, "The field name can not be empty");
        this.name = name;
        CodePatternValidation.isValidUrl(code, "The code pattern accept only low case characters, numbers and hyphen");
        this.code = code;
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

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public int getOrder() {
        return order;
    }

    public File getIcon() {
        return icon;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", categoryStatus=" + categoryStatus +
                ", order=" + order +
                ", icon='" + icon + '\'' +
                ", hexaColor='" + hexaColor + '\'' +
                '}';
    }
}
