package br.com.alura.humandev.controllers;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ca")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    @GetMapping
//    @ResponseBody
//    public List<Category> findAll(){
//        List<Category> categories = categoryRepository.findAll();
//        return categories;
//    }

    @GetMapping
    public String listAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categoriesList"; 

////    @GetMapping("/test")
////    public String cat() {
////        return "categoriesList";
////    }
    }
}
