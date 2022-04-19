package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.listDtos.CourseDto;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository ;

    public CourseController(CourseRepository courseRepository,
                            SubcategoryRepository subcategoryRepository,
                            CategoryRepository categoryRepository) {
        this.courseRepository =  courseRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}")
    public String listAll(@PathVariable String categoryCode,
                          @PathVariable String subcategoryCode,
                          @RequestParam(defaultValue = "0") Optional<Integer> page,
                          Model model) {
        int pageInt = page.filter(p -> p > 0).orElse(1) - 1;
        Pageable pageable = PageRequest.of(pageInt, 5);
        Subcategory subcategory = subcategoryRepository.findByCode(subcategoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Page<CourseDto> courses = courseRepository.findAllBySubcategory(subcategory, pageable)
                .map(CourseDto::new);
        model.addAttribute("subcategory", subcategory);
        model.addAttribute("coursesPage", courses);
        model.addAttribute("categorycode", categoryCode);
        return "courses/coursesList";
    }

}