package br.com.alura.humandev.controllers.api;

import br.com.alura.humandev.dtos.api.CategoryDtoApi;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    public CategoryApiController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(path="api/categories", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Cacheable(value = "categories")
    public ResponseEntity<List<CategoryDtoApi>> findAllActiveCategories() {
        List<Category> categories = categoryRepository.findAllByActiveIsTrue();
        List<CategoryDtoApi> categoryDto = categories.stream().map(CategoryDtoApi::new).toList();
        return ResponseEntity.ok().body(categoryDto);
    }

    @GetMapping(path = "api/bGltcGEtby1jYWNoZS1kYS1hcGktYWU")
    @CacheEvict(value = "categories")
    @ResponseStatus(HttpStatus.OK)
    public void cleanCash() {
    }
}
