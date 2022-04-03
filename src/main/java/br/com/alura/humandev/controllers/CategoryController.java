package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.CategoryFormDto;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/c")
    @ResponseBody
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @GetMapping("/categories")
    public String listAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categoriesList";
    }

    @GetMapping(value = "/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "postcategory";
    }


    @RequestMapping(value = "/postcat", method = RequestMethod.POST)
    public ModelAndView addCategory(@Valid @RequestBody CategoryFormDto categoryDto, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        ModelAndView view = new ModelAndView("postcategory");
        categoryRepository.save(categoryDto.toEntity());
        return view;
    }

    @PutMapping("/category/{code}")
    @Transactional
    public String editCategoryByCode(@Valid @PathVariable String code, @RequestBody CategoryFormDto categoryDto) {
        Category category = categoryDto.update(code, categoryRepository);
        return null;
     }
}
