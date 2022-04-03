package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Subcategory;

import java.util.List;

public class CategoryDtoApi {

    private String name;
    private String code;
    private Integer ordination;
    private String hexaColor;
    private String studyGuide;
    private int totalCourses;
    private List<SubcategoryDtoApi> subcategoryDtoApi;

    public CategoryDtoApi(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.ordination = category.getOrdination();
        this.hexaColor = category.getHexaColor();
        this.studyGuide = category.getStudyGuide();
       // this.totalCourses = category.getNumberOfCourses(new Subcategory());
        this.subcategoryDtoApi = SubcategoryDtoApi.toDto(category.getSubcategories());
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getOrdination() {
        return ordination;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public List<SubcategoryDtoApi> getSubcategoryApis() {
        return subcategoryDtoApi;
    }
}
