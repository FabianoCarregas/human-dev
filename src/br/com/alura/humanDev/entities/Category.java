package br.com.alura.humanDev.entities;

import static br.com.alura.humanDev.validations.CodePatternValidation.validColor;
import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.notBlankOrNull;

public class Category {

    private String name;
    private String code;
    private String categoryDescription;
    private String studyGuide;
    private boolean active;
    private Integer order;
    private String icon;
    private String hexaColor;

    public Category(String name,
                    String code,
                    Integer order,
                    String categoryDescription,
                    boolean categoryStatus,
                    String icon,
                    String hexaColor) {
        notBlankOrNull(name);
        validUrl(code);
        validColor(hexaColor);
        this.name = name;
        this.code = code;
        this.categoryDescription = categoryDescription;
        this.active = categoryStatus;
        this.order = order;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getIcon() {
        return icon;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    @Override
    public String toString() {
        return  "Categories {\n" +
                "    \"name\" = \""+ name + "\",\n" +
                "    \"code\" = \"" + code + "\",\n" +
                "    \"categoryDescription\" = \"" + categoryDescription + "\",\n" +
                "    \"categoryStatus \"= " + active + ",\n" +
                "    \"order\" = " + order + ",\n" +
                "    \"icon\" = \"" + icon + "\",\n" +
                "    \"hexaColor\" = \"" + hexaColor + "\"" + ";\n" +
                '}';
    }

}
