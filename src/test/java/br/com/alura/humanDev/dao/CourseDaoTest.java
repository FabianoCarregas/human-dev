package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.jpa.CourseDAO;
import br.com.alura.humanDev.jpa.JPAUtil;
import br.com.alura.humanDev.jpa.builder.CategoryBuilder;
import br.com.alura.humanDev.jpa.builder.CourseBuilder;
import br.com.alura.humanDev.jpa.builder.SubcategoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseDaoTest {

    private Subcategory subcategory;
    private Category category;
    private CourseDAO dao;
    private EntityManager em ;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManagerTest();
        this.dao = new CourseDAO(em);
        em.getTransaction().begin();

        this.category = new CategoryBuilder()
                .withName("Development")
                .withCode("dev")
                .withOrdination(2)
                .withCategoryDescription("course")
                .withActive(true)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
        em.persist(category);

        this.subcategory = new SubcategoryBuilder()
                .withName("java")
                .withCode("code")
                .withOrdination(1)
                .withSubcategoryDescription("desc")
                .withActive(true)
                .withCategory(category)
                .create();
        em.persist(subcategory);
   }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    private Course createCourse() {
        Course course = new CourseBuilder()
                .withName("name")
                .withCode("code-test")
                .withCourseTimeHours(1)
                .withStatus(false)
                .withTargetAudience("")
                .withIntructor("Bia")
                .withCourseDescription("")
                .withDevelopedSkills("")
                .withSubcategory(subcategory)
                .create();
        em.persist(course);
        return course;
    }

    private Course createCourse2() {
        Course course = new CourseBuilder()
                .withName("course-true")
                .withCode("code-test")
                .withCourseTimeHours(1)
                .withStatus(true)
                .withTargetAudience("")
                .withIntructor("Bia")
                .withCourseDescription("")
                .withDevelopedSkills("")
                .withSubcategory(subcategory)
                .create();
        em.persist(course);
        return course;
    }

    @Test
    void shouldShowPublicCourses() {
        createCourse();
        createCourse2();

        List<Course> courses = this.dao.showPublicCourses();

        assertEquals(1, courses.size());
        assertEquals("course-true", courses.get(0).getName());
    }

    @Test
    void shouldUpdateCourseStatusToPublic() {
        createCourse();
        createCourse2();
        this.dao.updateCourseStatusToPublic();
        List<Course> courses = this.dao.showPublicCourses();

        assertEquals(2, courses.size());
    }

}


