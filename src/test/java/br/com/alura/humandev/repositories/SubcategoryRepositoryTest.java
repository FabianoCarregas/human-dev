package br.com.alura.humandev.repositories;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.projections.SubcategoryLinkProjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SubcategoryRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SubcategoryRepository repository;

    @Test
    public void findActiveSubcategoryByCategoryCode__should_return_active_subcategory_by_category_code() {
        Category category = createCategory("code", true);
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "course");

        Category category1 = createCategory("code-test", true);
        Subcategory subcategory1 = createSubcategory(category1, true, "sub1");
        Course course1 = createCourse(subcategory1, false, "cours");

        List<SubcategoryLinkProjection> subcategoriesFound = repository.findActiveSubcategoryByCategoryCode("code");
        assertEquals(1, subcategoriesFound.size());
        assertEquals("sub", subcategoriesFound.get(0).getCode());
        assertNotEquals("sub1", subcategoriesFound.get(0).getCode());
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