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
@RequestMapping
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("admin/categories")
    public String listAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDto = categories.stream().map(CategoryDto::new).toList();
        model.addAttribute("categories", categories);
        return "categoriesList";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "postcategory";
    }

    @PostMapping("admin/categories/new")
    public String addCategory(@Valid CategoryFormDto categoryDto, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        categoryRepository.save(categoryDto.toEntity());
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{code}")
    public String showCategoryToUpdate(@PathVariable String code, Model model) {
        Category category = categoryRepository.findByCode(code);
        model.addAttribute("category", CategoryFormDto.toDto(category));
        return "putCategories";
    }

    @PostMapping("/admin/categories{code}")
    public String editCategoryByCode(@Valid CategoryFormDto categoryDto, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        categoryRepository.save(categoryDto.toEntity());
        return "redirect:admin/categories";
     }

}



