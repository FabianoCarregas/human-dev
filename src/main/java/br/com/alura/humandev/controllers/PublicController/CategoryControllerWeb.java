package br.com.alura.humandev.controllers.PublicController;

import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryControllerWeb {

    private final CategoryRepository categoryRepository;

    public CategoryControllerWeb(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



}
