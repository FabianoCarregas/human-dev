package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.CategoryFormDto;
import br.com.alura.humandev.dtos.SubcategoryFormDto;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/subcategories")
public class SubcategoryController {

    private final SubcategoryRepository subcategoryRepository;

    private  final CategoryRepository categoryRepository;

    public SubcategoryController(
            SubcategoryRepository subcategoryRepository,
            CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{code}")
    public String getAllSubcategoriesByOrder(@PathVariable String code, Model model) {
        Category category = categoryRepository.findByCode(code);
        List<Subcategory> subcategories = category.getSubcategories().stream().
                sorted(Comparator.comparingInt(Subcategory::getOrdination)).collect(Collectors.toList());
        model.addAttribute("category", CategoryFormDto.toDto(category));
        model.addAttribute("subcategories", SubcategoryFormDto.toDtoList(subcategories));
        return "subcategories/subcategoriesList";
    }

    @GetMapping("/new")
    public String addSubcategoryFormWithCategory(SubcategoryFormDto subcategoryFormDto, Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "subcategories/postsubcategory";
    }

    @PostMapping
    public String addNewCategory(@Valid SubcategoryFormDto subcategoryFormDto, BindingResult result, Model model) {
       Category category = categoryRepository.findById(subcategoryFormDto.getCategoryId()).orElseThrow(RuntimeException::new);
        if (result.hasErrors()) {
            return addSubcategoryFormWithCategory(subcategoryFormDto, model);
        }
        subcategoryRepository.save(subcategoryFormDto.toEntity(category));
        return getAllSubcategoriesByOrder(category.getCode(), model) ;
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String showEditSubcategory(@PathVariable String categoryCode,@PathVariable String subcategoryCode, Model model) {
        List<Category> categories = categoryRepository.findAll();
        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryCode);
        model.addAttribute("subcategory", subcategory);
        model.addAttribute("categories", categories);
        return "subcategories/putSubcategories";
    }

    @PostMapping("/{categoryCode}/{subcategoryCode}")
    public String editSubcategoryByCode(@PathVariable String categoryCode,@PathVariable String subcategoryCode,
                                        SubcategoryFormDto subcategoryFormDto, BindingResult result, Model model) {
        Category category = categoryRepository.findById(subcategoryFormDto.getCategoryId()).orElseThrow(RuntimeException::new);
        if (result.hasErrors()) {
            return showEditSubcategory(categoryCode, subcategoryCode, model);
        }
        subcategoryRepository.save(subcategoryFormDto.toEntity(category));
        return "redirect:/admin/subcategories";
    }
}

