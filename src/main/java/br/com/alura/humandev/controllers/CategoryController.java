package br.com.alura.humandev.controllers;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

//    @PostMapping("/add")
//    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//        categoryRepository.save(category.getName(), category.getCode(), category.getCategoryDescription(), category.isActive(),
//                category.getOrdination(), category.getIcon(), category.getHexaColor());
//        return null;
//
//    }
}
