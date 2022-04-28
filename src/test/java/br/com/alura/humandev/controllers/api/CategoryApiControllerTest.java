package br.com.alura.humandev.controllers.api;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.dtos.api.CategoryDtoApi;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import br.com.alura.humandev.repositories.CourseRepositoryTest;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.is;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

    @AfterEach
    public void cleanAll() {
        courseRepository.deleteAll();
        subcategoryRepository.deleteAll();
        courseRepository.deleteAll();
    }

    @Test
    public void should_retrieve_find_AllActiveCategoriesAndReturn200() throws Exception {
        URI uri = new URI("/api/categories");

        Category category = createCategory("java", "Java");
        Subcategory subcategory = createSubcategory(category,"Subcategory", "subcategory");
        Course course = createCourse(subcategory, "Course", "course");

        categoryRepository.flush();
        subcategoryRepository.flush();
        courseRepository.flush();

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code").value("java"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Java"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].code").value("subcategory"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].name").value("Subcategory"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].courseDtoApi[0].code").value("course"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryApis[0].courseDtoApi[0].name").value("Course"));

    }

//    @Test
//    public void not_found_when_does_not_exist() throws Exception {
//        URI uri = new URI("/api/categories");
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get(uri)
//                        .content(MediaType.APPLICATION_XML_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void shouldCleanCash() throws Exception {
//        URI uri = new URI("api/bGltcGEtby1jYWNoZS1kYS1hcGktYWU");
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get(uri)
//                        .content(MediaType.APPLICATION_JSON_VALUE)
//                        .content(MediaType.APPLICATION_XML_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }

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