package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.LoginForm;
import br.com.alura.humandev.projections.CategoryLinkProjection;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.security.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    private final CategoryRepository categoryRepository ;
    private final AuthenticationService authenticationService;

    public LoginController(CategoryRepository categoryRepository, AuthenticationService authenticationService ) {
        this.categoryRepository = categoryRepository;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        List<CategoryLinkProjection> categories = categoryRepository.findAllCategoriesbyActiveCourses();
        model.addAttribute("categories", categories);
        return "config/login";
    }
    public void login(LoginForm loginForm) {
        authenticationService.loadUserByUsername(loginForm.getEmail());
    }
}
