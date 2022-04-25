package br.com.alura.humandev.dtos.listDtos;
import br.com.alura.humandev.entities.Category;
import java.util.List;

public class CategoryDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;
    private String icon;
    private List<SubcategoryDto> subcategoriesDto;

    @Deprecated
    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.id =  category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.icon = category.getIcon();
        this.subcategoriesDto = SubcategoryDto.toDto(category.getSubcategories());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SubcategoryDto> getSubcategoriesDto() {
        return subcategoriesDto;
    }

    public void setSubcategoriesDto(List<SubcategoryDto> subcategoriesDto) {
        this.subcategoriesDto = subcategoriesDto;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
