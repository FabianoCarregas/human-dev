package br.com.alura.humandev.dtos.api;

import br.com.alura.humandev.entities.Category;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOrdination(Integer ordination) {
        this.ordination = ordination;
    }

}

