package br.com.alura.humandev.controllers.dashboard;

import br.com.alura.humandev.projections.CategoryProjection;
import br.com.alura.humandev.projections.InstructorProjection;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CourseRepository courseRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository ;

    public AdminController(CourseRepository courseRepository,
                            SubcategoryRepository subcategoryRepository,
                            CategoryRepository categoryRepository) {
        this.courseRepository =  courseRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String rediretToDashBoard() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        List<CategoryProjection> categoriesProjectionList = categoryRepository.findCategoryWithNumberOfCourses();
        InstructorProjection instructor = courseRepository.findInstructor();
        model.addAttribute("instructor", instructor);
        model.addAttribute("categories", categoriesProjectionList);
        return "reports/report";

    }
}
