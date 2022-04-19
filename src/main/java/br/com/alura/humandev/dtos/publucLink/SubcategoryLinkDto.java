package br.com.alura.humandev.dtos.publucLink;

import br.com.alura.humandev.entities.Subcategory;

import java.util.List;

public class SubcategoryLinkDto {

    private String name;
    private String code;
    private List<CourseLinkDto> courseLinkDtos;

    public SubcategoryLinkDto() {
    }

    public SubcategoryLinkDto(Subcategory subcategory) {
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.courseLinkDtos = subcategory.getCourses().stream().map(CourseLinkDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CourseLinkDto> getCourseLinkDtos() {
        return courseLinkDtos;
    }

    public void setCourseLinkDtos(List<CourseLinkDto> courseLinkDtos) {
        this.courseLinkDtos = courseLinkDtos;
    }
}
