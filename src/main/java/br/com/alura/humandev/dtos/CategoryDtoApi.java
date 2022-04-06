package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Category;

import java.util.List;

public class CategoryDtoApi {

    private String name;
    private String code;
    private Integer ordination;
    private String hexaColor;
    private String studyGuide;
    private Integer totalCourses;
    private List<SubcategoryDtoApi> subcategoryDtoApi;


    public CategoryDtoApi(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.ordination = category.getOrdination();
        this.hexaColor = category.getHexaColor();
        this.studyGuide = category.getStudyGuide();
        this.subcategoryDtoApi = SubcategoryDtoApi.toDto(category.getSubcategories());
        this.totalCourses = subcategoryDtoApi.stream()
                .map(SubcategoryDtoApi::getCourseDtoApi)
                .mapToInt(List::size)
                .sum();
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

    public List<SubcategoryDtoApi> getSubcategoryApis() {
        return subcategoryDtoApi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOrdination(Integer ordination) {
        this.ordination = ordination;
    }

    public void setHexaColor(String hexaColor) {
        this.hexaColor = hexaColor;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public Integer getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(Integer totalCourses) {
        this.totalCourses = totalCourses;
    }

    public List<SubcategoryDtoApi> getSubcategoryDtoApi() {
        return subcategoryDtoApi;
    }

    public void setSubcategoryDtoApi(List<SubcategoryDtoApi> subcategoryDtoApi) {
        this.subcategoryDtoApi = subcategoryDtoApi;
    }
}
