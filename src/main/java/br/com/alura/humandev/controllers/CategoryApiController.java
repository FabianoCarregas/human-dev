package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.CategoryDtoApi;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    public CategoryApiController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("api/categories")
    public ResponseEntity<List<CategoryDtoApi>> findAllActiveCategories() {
        List<Category> categories = categoryRepository.findAllByActiveIsTrue();
        List<CategoryDtoApi> categoryDto = categories.stream().map(CategoryDtoApi::new).toList();
        return ResponseEntity.ok().body(categoryDto);
    }
}
