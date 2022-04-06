package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Subcategory;

import java.util.List;

public class SubcategoryDtoApi {

    private String name;
    private String code;
    private String subcategoryDescription;
    private List<CourseDtoApi> courseDtoApi;

    public SubcategoryDtoApi(Subcategory subcategory) {
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.subcategoryDescription = subcategory.getSubcategoryDescription();
        this.courseDtoApi = CourseDtoApi.toDto(subcategory.getCourses());
    }

    public static List<SubcategoryDtoApi> toDto(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDtoApi::new).toList();
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

    public List<CourseDtoApi> getCourseDto() {
        return courseDtoApi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSubcategoryDescription(String subcategoryDescription) {
        this.subcategoryDescription = subcategoryDescription;
    }

    public List<CourseDtoApi> getCourseDtoApi() {
        return courseDtoApi;
    }

    public void setCourseDtoApi(List<CourseDtoApi> courseDtoApi) {
        this.courseDtoApi = courseDtoApi;
    }
}
