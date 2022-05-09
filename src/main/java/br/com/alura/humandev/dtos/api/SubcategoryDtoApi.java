package br.com.alura.humandev.dtos.api;

import br.com.alura.humandev.entities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
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

}