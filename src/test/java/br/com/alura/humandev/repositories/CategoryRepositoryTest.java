package br.com.alura.humandev.repositories;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.projections.CategoryLinkProjection;
import br.com.alura.humandev.projections.CategoryProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void findAllByActiveIsTrue__should_return_all_categories_by_active_status() {
        Category category = createCategory("code", true, "Java");
        Category category1 = createCategory("code1", true, "Java1");

        List<Category> categoriesFound = categoryRepository.findAllByActiveIsTrue();
        assertEquals(2,categoriesFound.size());
        assertEquals("code", categoriesFound.get(0).getCode());
        assertEquals("code1", categoriesFound.get(1).getCode());
        assertTrue(categoriesFound.get(0).isActive());
        assertTrue(categoriesFound.get(1).isActive());
    }

    @Test
    public void findAllByActiveIsTrue__should_not_return_a_deactivated_category() {
        Category category = createCategory("code", false, "Java");

        List<Category> categoriesFound = categoryRepository.findAllByActiveIsTrue();
        assertEquals(0,categoriesFound.size());
    }

    @Test
    public void findCategoryWithNumberOfCourses__should_return_category_with_number_of_courses() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");
        Course course1 = createCourse(subcategory, true, "cours1");

        Category category1 = createCategory("code1", true, "Java1");
        Subcategory subcategory1 = createSubcategory(category1, true, "sub");
        Course course2 = createCourse(subcategory1, true, "cours");

        List<CategoryProjection> categoriesFound = categoryRepository.findCategoryWithNumberOfCourses();
        assertEquals(2, categoriesFound.size());
        assertEquals("Java", categoriesFound.get(0).getName());
        assertEquals(2, categoriesFound.get(0).getCoursesQuantity());
        assertEquals("Java1", categoriesFound.get(1).getName());
        assertEquals(1, categoriesFound.get(1).getCoursesQuantity());
    }

    @Test
    public void findCategoryWithNumberOfCourses__should_return_categories_with_quantity_of_courses_by_desc_order() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");
        Course course1 = createCourse(subcategory, true, "cours1");

        Category category1 = createCategory("code", true, "Java1");
        Subcategory subcategory1 = createSubcategory(category1, true, "sub");
        Course course2 = createCourse(subcategory1, true, "cours");

        List<CategoryProjection> categoriesFound = categoryRepository.findCategoryWithNumberOfCourses();
        assertEquals(2, categoriesFound.get(0).getCoursesQuantity());
        assertEquals(1, categoriesFound.get(1).getCoursesQuantity());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_not_find_category_if_category_is_deactivated() {
        Category category1 = createCategory("code", false, "Java2");
        Subcategory subcategory1 = createSubcategory(category1, true, "sub-one");
        Course course1 = createCourse(subcategory1, true, "cours-one");

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(0, categoriesFound.size());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_not_find_category_if_subcategory_is_deactivated() {
        Category category1 = createCategory("code", true, "Java2");
        Subcategory subcategory1 = createSubcategory(category1, false, "sub-one");
        Course course1 = createCourse(subcategory1, true, "cours-one");

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(0, categoriesFound.size());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_not_find_category_if_course_is_deactivated() {
        Category category1 = createCategory("code", true, "Java2");
        Subcategory subcategory1 = createSubcategory(category1, true, "sub-one");
        Course course1 = createCourse(subcategory1, false, "cours-one");

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(0, categoriesFound.size());
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_return_if_category_active_subcategory_active_course_active() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");

        CategoryLinkProjection categoryFound = categoryRepository.findCategoryByCodeAndActiveCourses("code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("code", categoryFound.getCode());
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_not_return_if_category_deactivated() {
        Category category = createCategory("code", false, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours");

        assertThrows(RuntimeException.class, () ->
                categoryRepository.findCategoryByCodeAndActiveCourses("code")
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_not_return_if_subcategory_deactivated() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, false, "sub");
        Course course = createCourse(subcategory, true, "cours");

        assertThrows(RuntimeException.class, () ->
                categoryRepository.findCategoryByCodeAndActiveCourses("code")
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_not_return_if_course_deactivated() {
        Category category = createCategory("code", true, "Java");
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, false, "cours");

        assertThrows(RuntimeException.class, () ->
                categoryRepository.findCategoryByCodeAndActiveCourses("code")
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
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