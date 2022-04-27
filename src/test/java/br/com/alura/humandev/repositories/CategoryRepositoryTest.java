package br.com.alura.humandev.repositories;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;

import br.com.alura.humandev.projections.CategoryLinkProjection;
import br.com.alura.humandev.projections.CategoryProjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void findAllByActiveIsTrue__should_return_all_categories_by_active_true() {
        Category category = createCategory("code", true, "Java");
        Category category2 = createCategory("code-false", false, "Java");

        List<Category> categoriesFound = categoryRepository.findAllByActiveIsTrue();
        assertEquals("code", categoriesFound.get(0).getCode());
        assertEquals(1,categoriesFound.size());
        assertTrue(categoriesFound.get(0).isActive());
        assertNotEquals("code-false", categoriesFound.get(0).getCode());
    }

    @Test
    public void FindCategoryWithNumberOfCourses__should_return_category_with_number_of_courses() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");
        Course course1 = createCourse(subcategory, true, "cours1");

        Category category1 = createCategory("code", true, "Java1");
        Subcategory subcategory1 = createSubcategory(category1, true, "sub");
        Course course2 = createCourse(subcategory1, true, "cours");

        List<CategoryProjection> categoriesFound = categoryRepository.findCategoryWithNumberOfCourses();
        assertEquals("Java", categoriesFound.get(0).getName());
        assertEquals(2, categoriesFound.get(0).getCoursesQuantity());
        assertEquals("Java1", categoriesFound.get(1).getName());
        assertEquals(1, categoriesFound.get(1).getCoursesQuantity());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_return_all_categories_by_active_courses() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");

        Category category1 = createCategory("code-one", true, "Java2");
        Subcategory subcategory1 = createSubcategory(category1, true, "sub-one");
        Course course1 = createCourse(subcategory1, false, "cours-one");

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(1, categoriesFound.size());
        assertEquals("code", categoriesFound.get(0).getCode());
        assertNotEquals("code-one", categoriesFound.get(0).getCode());
    }

    @Test
    public void FindCategoryByCodeAndActiveCourses__should_return_category_by_code_and_active_courses() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");

        Category category1 = createCategory("code-one", true, "Java");
        Subcategory subcategory1 = createSubcategory(category1, true, "subcat");
        Course course1 = createCourse(subcategory1, false, "course");

        CategoryLinkProjection categoryFound = categoryRepository.findCategoryByCodeAndActiveCourses("code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("code", categoryFound.getCode());
        assertNotEquals("code-one", categoryFound.getCode());

    }

    private Category createCategory(String code, boolean active, String name) {
        Category category = new CategoryBuilder()
                .withName(name)
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