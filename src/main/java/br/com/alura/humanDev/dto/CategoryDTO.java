package br.com.alura.humanDev.dto;

public class CategoryDTO {
    private String name;
    private String code;
    private Integer ordination;
    private String categoryDescription;
    private boolean active;
    private String icon;
    private String hexaColor;

    public CategoryDTO(String name,
                       String code,
                       Integer ordination,
                       String categoryDescription,
                       boolean active,
                       String icon,
                       String hexaColor) {
        this.name = name;
        this.code = code;
        this.ordination = ordination;
        this.categoryDescription = categoryDescription;
        this.active = active;
        this.icon = icon;
        this.hexaColor = hexaColor;
    }

}
