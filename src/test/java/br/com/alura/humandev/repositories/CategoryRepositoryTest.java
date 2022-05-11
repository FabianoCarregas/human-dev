package br.com.alura.humandev.repositories;

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
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager em;

    private final String java = "Java";
    private final String aws = "AWS";
    private final String github = "GitHub";
    private final String cssCode = "css-code";
    private final String javaCode = "java-code";
    private final String awsCode = "aws-code";
    private final String devopsCode = "devops-code";
    private final String frontendCode = "frontend-code";
    private final String githubCode = "github-code";
    private final String mobileCode = "mobile-code";

    @Test
    public void findAllByActiveIsTrue__should_return_category_list_if_active_status_true() {
        Category categoryJava = createCategory(javaCode, true, java);
        Category categoryAws = createCategory(awsCode, true, aws);

        List<Category> categoriesFound = categoryRepository.findAllByActiveIsTrue();
        assertEquals(2,categoriesFound.size());
        assertEquals(javaCode, categoriesFound.get(0).getCode());
        assertEquals(awsCode, categoriesFound.get(1).getCode());
        assertTrue(categoriesFound.get(0).isActive());
        assertTrue(categoriesFound.get(1).isActive());
    }

    @Test
    public void findAllByActiveIsTrue__should_return_an_empty_category_list_if_active_status_false() {
        Category categoryJava = createCategory(javaCode, false, java);

        List<Category> categoriesFound = categoryRepository.findAllByActiveIsTrue();
        assertEquals(0,categoriesFound.size());
    }

    @Test
    public void findCategoryWithNumberOfCourses__should_return_a_category_list_with_number_of_courses() {
        Category categoryJava = createCategory(javaCode, true, java);
        Subcategory subcategoryAws = createSubcategory(categoryJava, true, awsCode);
        Course courseDevOps = createCourse(subcategoryAws, true, devopsCode);
        Course courseFrontend = createCourse(subcategoryAws, true, frontendCode);

        Category categoryGithub = createCategory(githubCode, true, github);
        Subcategory subcategoryCss = createSubcategory(categoryGithub, true, cssCode);
        Course courseMobile = createCourse(subcategoryCss, true, mobileCode);

        List<CategoryProjection> categoriesFound = categoryRepository.findCategoryWithNumberOfCourses();
        assertEquals(2, categoriesFound.size());
        assertEquals(java, categoriesFound.get(0).getName());
        assertEquals(2, categoriesFound.get(0).getCoursesQuantity());
        assertEquals(github, categoriesFound.get(1).getName());
        assertEquals(1, categoriesFound.get(1).getCoursesQuantity());
    }

    @Test
    public void findCategoryWithNumberOfCourses__should_return_category_list_with_number_of_courses_by_descending_order() {
        Category categoryJava = createCategory(javaCode, true, java);
        Subcategory subcategoryAws = createSubcategory(categoryJava, true, awsCode);
        Course courseDevops = createCourse(subcategoryAws, true, devopsCode);
        Course courseFrontend = createCourse(subcategoryAws, true, frontendCode);

        Category categoryGithub = createCategory(githubCode, true, github);
        Subcategory subcategoryCss = createSubcategory(categoryGithub, true, cssCode);
        Course courseMobile = createCourse(subcategoryCss, true, mobileCode);

        List<CategoryProjection> categoriesFound = categoryRepository.findCategoryWithNumberOfCourses();
        assertEquals(2, categoriesFound.get(0).getCoursesQuantity());
        assertEquals(1, categoriesFound.get(1).getCoursesQuantity());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_return_an_empty_category_list_if_status_is_false() {
        Category categoryGithub = createCategory(githubCode, false, github);
        Subcategory subcategoryCss = createSubcategory(categoryGithub, true, cssCode);
        Course courseMobile = createCourse(subcategoryCss, true, mobileCode);

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(0, categoriesFound.size());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_return_an_empty_subcategory_list_if_status_is_false() {
        Category categoryGithub = createCategory(githubCode, true, github);
        Subcategory subcategoryCss = createSubcategory(categoryGithub, false, cssCode);
        Course courseMobile = createCourse(subcategoryCss, true, mobileCode);

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(0, categoriesFound.size());
    }

    @Test
    public void findAllCategoriesbyActiveCourses__should_return_an_empty_course_list_if_status_is_false() {
        Category categoryGithub = createCategory(githubCode, true, github);
        Subcategory subcategoryCss = createSubcategory(categoryGithub, true, cssCode);
        Course courseMobile = createCourse(subcategoryCss, false, mobileCode);

        List<CategoryLinkProjection> categoriesFound = categoryRepository.findAllCategoriesbyActiveCourses();
        assertEquals(0, categoriesFound.size());
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_return_a_category() {
        Category categoryJava = createCategory(javaCode, true, java);
        Subcategory subcategoryAws = createSubcategory(categoryJava, true, awsCode);
        Course courseGithub = createCourse(subcategoryAws, true, githubCode);

        Optional<CategoryLinkProjection> code = categoryRepository.findCategoryByCodeAndActiveCourses(javaCode);
        assertTrue(code.isPresent());
        assertEquals(javaCode, code.get().getCode());
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_return_empty_if_category_status_is_false() {
        Category categoryJava = createCategory(javaCode, false, java);
        Subcategory subcategoryAws = createSubcategory(categoryJava, true, awsCode);
        Course courseGithub = createCourse(subcategoryAws, true, githubCode);

        Optional<CategoryLinkProjection> code = categoryRepository.findCategoryByCodeAndActiveCourses(javaCode);
        assertFalse(code.isPresent());
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_return_empty_if_subcategory_status_is_false() {
        Category categoryJava = createCategory(javaCode, true, java);
        Subcategory subcategoryAws = createSubcategory(categoryJava, false, awsCode);
        Course courseGithub = createCourse(subcategoryAws, true, githubCode);

        Optional<CategoryLinkProjection> code = categoryRepository.findCategoryByCodeAndActiveCourses(javaCode);
        assertFalse(code.isPresent());
    }

    @Test
    public void findCategoryByCodeAndActiveCourses__should_return_empty_if_course_status_is_false() {
        Category categoryJava = createCategory(javaCode, true, java);
        Subcategory subcategoryAws = createSubcategory(categoryJava, true, awsCode);
        Course courseHithub = createCourse(subcategoryAws, false, githubCode);

        Optional<CategoryLinkProjection> code = categoryRepository.findCategoryByCodeAndActiveCourses(javaCode);
        assertFalse(code.isPresent());
    }

    private Category createCategory(String code, boolean active, String name) {
        Category category = Category.builder()
                .name(name)
                .code(code)
                .ordination(4)
                .categoryDescription("course")
                .active(active)
                .icon("http")
                .hexaColor("#FFF")
                .build();
        em.persist(category);
        return category;
    }

    private Subcategory createSubcategory(Category category, boolean active, String code) {
        Subcategory subcategory = Subcategory.builder()
                .name("java")
                .code(code)
                .ordination(1)
                .subcategoryDescription("desc")
                .active(active)
                .category(category)
                .build();
        em.persist(subcategory);
        return subcategory;
    }

    private Course createCourse(Subcategory subcategory, boolean active, String code) {
        Course course = Course.builder()
                .name("java")
                .code(code)
                .courseTimeHours(1)
                .active(active)
                .targetAudience("")
                .instructor("Bia")
                .courseDescription("")
                .developedSkills("")
                .subcategory(subcategory)
                .build();
        em.persist(course);
        return course;
    }
}