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

import static br.com.alura.humanDev.readers.CourseReader.showAllInstructors;
import static org.junit.jupiter.api.Assertions.*;

public class CourseDaoTest {

    private Subcategory subcategory;
    private Category category;
    private CourseDAO dao;
    private EntityManager em ;
    private String code = "code-test";

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

    @Test
    void shouldDeleteCourseByCode() {
        createCourse();
        this.dao.deleteCourseByCode(code);
        List<Course> courses = this.dao.findAllCourses();

        assertEquals(0, courses.size());
        assertFalse(courses.contains(courses));
    }

    @Test
    void shouldUpdateCourseStatusToPublic() {
        createCourse();
        this.dao.updateCourseStatusToPublic();
        List<Course> courses = this.dao.findAllCourses();

        assertEquals(1, courses.size());
        assertTrue(courses.get(0).isStatus());
    }

//    @Test
//    void shouldShowPublicCourses() {
//        createCourse();
//        this.dao.updateCourseStatusToPublic();
//        List<Course> courses = this.dao.showPublicCourses();
//
//        Assertions.assertEquals(1, courses.size());
//        Assertions.assertEquals(courses.get(0), createCourse().getClass());
//    }



}


