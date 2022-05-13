package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.forms.SubcategoryFormDto;
import br.com.alura.humandev.dtos.listDtos.CategoryDto;
import br.com.alura.humandev.dtos.listDtos.SubcategoryDto;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import br.com.alura.humandev.validators.SubcategoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryValidator subcategoryValidator;

    @InitBinder("subcategoryFormDto")
    void iniBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(subcategoryValidator);
    }

    @GetMapping("/{code}")
    public String getAllSubcategoriesByOrder(@PathVariable String code,
                                             Model model) {
        Category category = categoryRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Subcategory> subcategories = category.getSubcategories().stream().
                sorted(Comparator.comparingInt(Subcategory::getOrdination)).collect(Collectors.toList());
        model.addAttribute("category", new CategoryDto(category));
        model.addAttribute("subcategories", subcategories.stream().map(SubcategoryDto::new).toList());
        return "subcategories/subcategoriesList";
    }

    @GetMapping("/new")
    public String create(SubcategoryFormDto subcategoryFormDto,
                         BindingResult result, Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("subcategories", subcategoryFormDto);
        model.addAttribute("categories", categories.stream().map(CategoryDto::new).toList());
        return "subcategories/postsubcategory";
    }

    @PostMapping
    public String save(@Valid SubcategoryFormDto subcategoryFormDto,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return create(subcategoryFormDto, result, model);
        }
        Category category = categoryRepository.findById(subcategoryFormDto.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        subcategoryRepository.save(subcategoryFormDto.toEntity(category));
        return "redirect:/admin/subcategories/" + category.getCode();
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String edit(@PathVariable String categoryCode,
                       @PathVariable String subcategoryCode,
                       SubcategoryFormDto subcategoryFormDto,
                       BindingResult result,
                       Model model) {
        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Category> category = categoryRepository.findAll();
        model.addAttribute("category", category);
        model.addAttribute("subcategory", subcategory);
        model.addAttribute("subcategoryFormDto",
                result.hasErrors() ? subcategoryFormDto : new SubcategoryFormDto(subcategory));
        return "subcategories/putSubcategories";
    }

    @PostMapping("/{categoryCode}/{subcategoryCode}")
    public String update(@PathVariable String categoryCode,
                         @PathVariable String subcategoryCode,
                         @Valid SubcategoryFormDto subcategoryFormDto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return edit(categoryCode, subcategoryCode, subcategoryFormDto, result, model);
        }
        Category category = categoryRepository.findById(subcategoryFormDto.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        subcategoryRepository.save(subcategoryFormDto.toEntity(category));
        return "redirect:/admin/subcategories/" + category.getCode();
    }

    @PostMapping("/changeStatusSubcategory/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void changeSubcategoryStatus(@PathVariable Long id) {
        Subcategory subcategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        subcategory.deactivate();
        subcategoryRepository.save(subcategory);
    }

}