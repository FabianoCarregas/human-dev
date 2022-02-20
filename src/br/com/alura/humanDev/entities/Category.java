package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlank;
import static br.com.alura.humanDev.validations.Validation.notNull;

public class Category {

    private String name;
    private String code;
    private String categoryDescription;
    private String studyGuide;
    private boolean categoryStatus;
    private Integer order;
    private String icon;
    private String hexaColor;

    public Category(String name,
                    String code) {
        notNull(name);
        notBlank(name);
        this.name = name;
        validUrl(code);
        this.code = code;
    }

    public Category(String name, String code, Integer order, String categoryDescription, boolean categoryStatus, String icon, String hexaColor) {
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.categoryStatus = categoryStatus;
        this.order = order;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    @Override
    public String toString() {
        return  "Categories {\n" +
                "    \"name\" = " + name + ",\n" +
                "    \"code\" = " + code + ",\n" +
                "    \"categoryDescription\" = " + categoryDescription + ",\n" +
                "    \"categoryStatus \"= " + categoryStatus + ",\n" +
                "    \"order\" = " + order + ",\n" +
                "    \"icon\" = " + icon + ",\n" +
                "    \"hexaColor\" = " + hexaColor + '\'' + ";\n" +
                '}';
    }
}
