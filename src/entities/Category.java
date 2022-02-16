package entities;

import validations.CodePatternValidation;
import validations.Validation;

import java.io.File;

public class Category {

    private String name;
    private String code;
    private String categoryDescription;
    private String studyGuide;
    private boolean categoryStatus;
    private int order;
    private File icon;
    private String hexaColor;

    public Category(String name,
                    String code) {
        Validation.notNull(name);
        Validation.notBlank(name);
        this.name = name;
        CodePatternValidation.validUrl(code);
        this.code = code;
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
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", categoryStatus=" + categoryStatus +
                ", order=" + order +
                ", icon=" + icon +
                ", hexaColor='" + hexaColor + '\'' +
                '}';
    }
}
