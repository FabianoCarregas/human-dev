package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.CategoryDto;
import br.com.alura.humandev.dtos.CategoryFormDto;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String listAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDto = categories.stream().map(CategoryDto::new).toList();
        model.addAttribute("categories", categories);
        return "categories/categoriesList";
    }

    @GetMapping("/new")
    public String getAddCategoryForm(CategoryFormDto categoryFormDto) {
        return "categories/postcategory";
    }

    @PostMapping
    public String addCategory(@Valid CategoryFormDto categoryFormDto, BindingResult result) {
        if (result.hasErrors()) {
            return getAddCategoryForm(categoryFormDto);
        }
        categoryRepository.save(categoryFormDto.toEntity());
        return "redirect:/admin/categories";
    }

    @GetMapping("/{code}")
    public String showCategoryToUpdate(@PathVariable String code, Model model) {
        Category category = categoryRepository.findByCode(code);
        model.addAttribute("category",CategoryFormDto.toDto(category));
        return "categories/putCategories";
    }

    @PostMapping("/{code}")
    public String editCategoryByCode(@PathVariable String code, @Valid CategoryFormDto categoryFormDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return showCategoryToUpdate(code, model);
        }
        Category category = categoryFormDto.toEntity();
        categoryRepository.save(category);
        return "redirect:/admin/categories";
     }

}