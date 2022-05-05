package br.com.alura.humandev.repositories;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.projections.SubcategoryLinkProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SubcategoryRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SubcategoryRepository repository;

    private final String cssCode = "css-code";
    private final String javaCode = "java-code";
    private final String awsCode = "aws-code";
    private final String frontendCode = "frontend-code";

    @Test
    public void findActiveSubcategoryByCategoryCode__should_return_a_subcategory_list() {
        Category categoryJava = createCategory(javaCode, true);
        Subcategory subcategoryCss = createSubcategory(categoryJava, true, cssCode);
        Course courseFrontend = createCourse(subcategoryCss, true, frontendCode);

        List<SubcategoryLinkProjection> subcategoriesFound = repository.findActiveSubcategoryByCategoryCode(javaCode);
        assertEquals(cssCode, subcategoriesFound.get(0).getCode());
        assertEquals(1, subcategoriesFound.size());
    }

    @Test
    public void findActiveSubcategoryByCategoryCode__should_return_an_empty_category_list_if_status_false() {
        Category categoryJava = createCategory(javaCode, false);
        Subcategory subcategoryCss = createSubcategory(categoryJava, true, cssCode);
        Course courseAws = createCourse(subcategoryCss, true, awsCode);

        List<SubcategoryLinkProjection> subcategoriesFound = repository.findActiveSubcategoryByCategoryCode(javaCode);
        assertEquals(0, subcategoriesFound.size());
    }

    @Test
    public void findActiveSubcategoryByCategoryCode__should_return_an_empty_subcategory_list_if_status_false() {
        Category categoryJava = createCategory(javaCode, true);
        Subcategory subcategoryCss = createSubcategory(categoryJava, false, cssCode);
        Course courseAws = createCourse(subcategoryCss, true, awsCode);

        List<SubcategoryLinkProjection> subcategoriesFound = repository.findActiveSubcategoryByCategoryCode(javaCode);
        assertEquals(0, subcategoriesFound.size());
    }

    @Test
    public void findActiveSubcategoryByCategoryCode__should_return_an_empty_course_list_if_status_is_false() {
        Category categoryJava = createCategory(javaCode, true);
        Subcategory subcategoryCss = createSubcategory(categoryJava, true, cssCode);
        Course courseAws = createCourse(subcategoryCss, false, awsCode);

        List<SubcategoryLinkProjection> subcategoriesFound = repository.findActiveSubcategoryByCategoryCode(javaCode);
        assertEquals(0, subcategoriesFound.size());
    }

    private Category createCategory(String code, boolean active) {
        Category category = new CategoryBuilder()
                .withName("java")
                .withCode(code)
                .withOrdination(4)
                .withCategoryDescription("course")
                .withActive(active)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
        em.persist(category);
        return category;
    }

    private Subcategory createSubcategory(Category category, boolean active, String code) {
        Subcategory subcategory = new SubcategoryBuilder()
                .withName("java")
                .withCode(code)
                .withOrdination(1)
                .withSubcategoryDescription("desc")
                .withActive(active)
                .withCategory(category)
                .create();
        em.persist(subcategory);
        return subcategory;
    }

    private Course createCourse(Subcategory subcategory, boolean active, String code) {
        Course course = new CourseBuilder()
                .withName("java")
                .withCode(code)
                .withCourseTimeHours(1)
                .withStatus(active)
                .withTargetAudience("")
                .withIntructor("Bia")
                .withCourseDescription("")
                .withDevelopedSkills("")
                .withSubcategory(subcategory)
                .create();
        em.persist(course);
        return course;
    }
}