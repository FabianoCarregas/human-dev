package br.com.alura.humandev.controllers;

import br.com.alura.humandev.dtos.forms.CourseFormDto;
import br.com.alura.humandev.dtos.listDtos.CourseDto;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import br.com.alura.humandev.validators.CourseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository ;
    private final CourseValidator courseValidator;

    @InitBinder("courseFormDto")
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(courseValidator);
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

    @GetMapping("/new")
    public String create(CourseFormDto courseFormDto,
                         BindingResult result, Model model) {
        List<Subcategory> subcategories = subcategoryRepository.findAll();
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("courseDto", courseFormDto);
        return "courses/postcourse";
    }

    @PostMapping
    public String save(@Valid CourseFormDto courseFormDto,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return create(courseFormDto, result, model);
        }
        Subcategory subcategory = subcategoryRepository.findById(courseFormDto.getSubcategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        courseRepository.save(courseFormDto.toEntity(subcategory));
        return "redirect:/admin/courses/" + subcategory.getCategory().getCode() +"/"+ subcategory.getCode() ;
    }

    @GetMapping("/{categoryCode}/{subcategoryCode}/{courseCode}")
    public String edit(@PathVariable String categoryCode,
                       @PathVariable String subcategoryCode,
                       @PathVariable String courseCode,
                       CourseFormDto courseFormDto,
                       BindingResult result,
                       Model model) {
        Course course = courseRepository.findByCode(courseCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Subcategory> subcategories = subcategoryRepository.findAll();
        model.addAttribute("course", course);
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("courseDto",
                result.hasErrors() ? courseFormDto :  new CourseFormDto(course));
        return "courses/putcourses";
    }

    @PostMapping("/{categoryCode}/{subcategoryCode}/{courseCode}")
    public String update(@PathVariable String categoryCode,
                        @PathVariable String subcategoryCode,
                        @PathVariable String courseCode,
                        @Valid CourseFormDto courseFormDto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return edit(categoryCode, subcategoryCode, courseCode, courseFormDto, result, model);
        }
        Subcategory subcategory = subcategoryRepository.findById(courseFormDto.getSubcategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        courseRepository.save(courseFormDto.toEntity(subcategory));
        return "redirect:/admin/courses/" + subcategory.getCategory().getCode() + "/" + subcategory.getCode();
    }

}