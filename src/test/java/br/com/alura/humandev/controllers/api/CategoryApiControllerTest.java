package br.com.alura.humandev.controllers.api;


import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Transactional
public class CategoryApiControllerTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MockMvc mockMvc;

    private final String java = "Java";
    private final String aws = "AWS";
    private final String github = "GitHub";
    private final String javaCode = "java-code";
    private final String awsCode = "aws-code";
    private final String githubCode = "github-code";

    @Test
    public void should_retrieve_category_subcatgory_course() throws Exception {
        URI uri = new URI("/api/categories");

        Category categoryJava = createCategory(javaCode, java);
        Subcategory subcategoryGithub = createSubcategory(categoryJava,github, githubCode);
        Course courseAws = createCourse(subcategoryGithub, aws, awsCode);
        categoryJava.setSubcategories(List.of(subcategoryGithub));
        subcategoryGithub.setCourses(List.of(courseAws));

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code")
                        .value(javaCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name")
                        .value(java))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryDtoApi[0].code")
                        .value(githubCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryDtoApi[0].name")
                        .value(github))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryDtoApi[0].courseDtoApi[0].code")
                        .value(awsCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subcategoryDtoApi[0].courseDtoApi[0].name")
                        .value(aws)).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void shouldCleanCash() throws Exception {
        URI uri = new URI("/api/bGltcGEtby1jYWNoZS1kYS1hcGktYWU");
        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    private Category createCategory(String code, String name) {
        Category category = Category.builder()
                .name(name)
                .code(code)
                .ordination(4)
                .categoryDescription("course")
                .active(true)
                .icon("http")
                .hexaColor("#FFF")
                .build();
        return categoryRepository.save(category);
    }

    private Subcategory createSubcategory(Category category, String name, String code) {
        Subcategory subcategory = Subcategory.builder()
                .name(name)
                .code(code)
                .ordination(1)
                .subcategoryDescription("desc")
                .active(true)
                .category(category)
                .build();
        return subcategoryRepository.save(subcategory);
    }

    private Course createCourse(Subcategory subcategory, String name, String code) {
        Course course = Course.builder()
                .name(name)
                .code(code)
                .courseTimeHours(1)
                .active(true)
                .targetAudience("")
                .instructor("Bia")
                .courseDescription("")
                .developedSkills("")
                .subcategory(subcategory)
                .build();
        return courseRepository.save(course);
    }


}