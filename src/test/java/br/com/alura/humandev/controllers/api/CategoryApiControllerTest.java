package br.com.alura.humandev.controllers.api;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CategoryApiControllerTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void should_retrieve_status_200() throws Exception {
        URI uri = new URI("/api/categories");

        Category category = createCategory("java", "Java");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @Transactional
    public void should_retrieve_category_subcatgory_course() throws Exception {
        URI uri = new URI("/api/categories");

        Category category = createCategory("java", "Java");
        Subcategory subcategory = createSubcategory(category,"Subcategory", "subcategory");
        Course course = createCourse(subcategory, "Course", "course");
        subcategory.setCourses(List.of(course));

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code").value("java"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Java"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].code")
                        .value("subcategory"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].name")
                        .value("Subcategory"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].courseDtoApi[0].code")
                        .value("course"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].courseDtoApi[0].name")
                        .value("Course"));
    }

    @Test
    @Transactional
    public void shouldCleanCash() throws Exception {

        URI uri = new URI("api/bGltcGEtby1jYWNoZS1kYS1hcGktYWU");
        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private Category createCategory(String code, String name) {
        Category category = new CategoryBuilder()
                .withName(name)
                .withCode(code)
                .withOrdination(4)
                .withCategoryDescription("course")
                .withActive(true)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
                return categoryRepository.save(category);
    }

    private Subcategory createSubcategory(Category category, String name, String code) {
        Subcategory subcategory = new SubcategoryBuilder()
                .withName(name)
                .withCode(code)
                .withOrdination(1)
                .withSubcategoryDescription("desc")
                .withActive(true)
                .withCategory(category)
                .create();
        return subcategoryRepository.save(subcategory);
    }

    private Course createCourse(Subcategory subcategory,String name, String code) {
        Course course = new CourseBuilder()
                .withName(name)
                .withCode(code)
                .withCourseTimeHours(1)
                .withStatus(true)
                .withTargetAudience("")
                .withIntructor("Bia")
                .withCourseDescription("")
                .withDevelopedSkills("")
                .withSubcategory(subcategory)
                .create();
                return courseRepository.save(course);
    }
}