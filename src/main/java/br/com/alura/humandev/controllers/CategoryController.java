package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.forms.CategoryFormDto;
import br.com.alura.humandev.dtos.listDtos.CategoryDto;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.projections.CategoryLinkProjection;
import br.com.alura.humandev.projections.SubcategoryLinkProjection;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller

public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public CategoryController(CategoryRepository categoryRepository,
                              SubcategoryRepository subcategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @GetMapping("/admin/categories")
    public String listAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDto = categories.stream().map(CategoryDto::new).toList();
        model.addAttribute("categories", categoryDto);
        return "categories/categoriesList";
    }

    @GetMapping("/admin/categories/new")
    public String create(CategoryFormDto categoryFormDto) {
        return "categories/postcategory";
    }

    @PostMapping("/admin/categories")
    public String save(@Valid CategoryFormDto categoryFormDto,
                       BindingResult result) {
        if (result.hasErrors()) {
            return create(categoryFormDto);
        }
        categoryRepository.save(categoryFormDto.toEntity());
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{code}")
    public String edit(@PathVariable String code, Model model) {
        Category category = categoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("category",CategoryFormDto.toDto(category));
        return "categories/putCategories";
    }

    @PostMapping("/admin/categories/{code}")
    public String update(@PathVariable String code,
                         @Valid CategoryFormDto categoryFormDto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return edit(code, model);
        }
        Category category = categoryFormDto.toEntity();
        categoryRepository.save(category);
        return "redirect:/admin/categories";
     }

    @PostMapping("/admin/categories/changeStatusCourse/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void changeStatus(@PathVariable Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        category.deactivate();
        categoryRepository.save(category);
    }

    @GetMapping("/category/{categoryCode}")
    public String getByActiveSubcategories(@PathVariable String categoryCode, Model model) {
        CategoryLinkProjection category = categoryRepository.findCategoryByCodeAndActiveCourses(categoryCode);
        List<SubcategoryLinkProjection> subcategories = subcategoryRepository.findActiveSubcategoryByCategoryCode(categoryCode);
        model.addAttribute("category", category);
        model.addAttribute("subcategories", subcategories);
        return "categories/linkCategory";
    }

}