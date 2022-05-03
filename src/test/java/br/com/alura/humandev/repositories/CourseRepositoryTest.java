package br.com.alura.humandev.repositories;

import br.com.alura.humandev.builders.CategoryBuilder;
import br.com.alura.humandev.builders.CourseBuilder;
import br.com.alura.humandev.builders.SubcategoryBuilder;
import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.projections.InstructorProjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private  CourseRepository repository;

    @Test
    public void findInstructor__should_return_instructor_with_number_of_courses() {
        Category category = createCategory("code", true);
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours", "Bia");

        InstructorProjection instructorFound = repository.findInstructor();
        assertEquals(1, instructorFound.getCoursesNumber());
        assertEquals("Bia", instructorFound.getInstructor());
    }

    @Test
    public void findInstructor__should_return_instructor_whith_the_higher_number_of_courses() {
        Category category = createCategory("code", true);
        Subcategory subcategory = createSubcategory(category, true, "sub");
        Course course = createCourse(subcategory, true, "cours", "Bia");
        Course course1 = createCourse(subcategory, true, "cours1", "Bia");

        Category category1 = createCategory("code", true);
        Subcategory subcategory1 = createSubcategory(category1, true, "sub2");
        Course course2 = createCourse(subcategory1, true, "cours", "Fabs");

        InstructorProjection instructorFound = repository.findInstructor();
        assertEquals(2, instructorFound.getCoursesNumber());
        assertEquals("Bia", instructorFound.getInstructor());
        assertNotEquals("fabs", instructorFound.getInstructor());
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

    private Course createCourse(Subcategory subcategory, boolean active, String code, String name) {
        Course course = new CourseBuilder()
                .withName("java")
                .withCode(code)
                .withCourseTimeHours(1)
                .withStatus(active)
                .withTargetAudience("")
                .withIntructor(name)
                .withCourseDescription("")
                .withDevelopedSkills("")
                .withSubcategory(subcategory)
                .create();
        em.persist(course);
        return course;
    }
}