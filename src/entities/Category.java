package entities;

import static validations.Validation.notNull;
import static validations.Validation.notBlank;
import static validations.CodePatternValidation.validUrl;

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
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
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
