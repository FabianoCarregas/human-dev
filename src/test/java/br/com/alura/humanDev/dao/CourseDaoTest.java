package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.util.JPAUtilTest;
import br.com.alura.humanDev.builders.CategoryBuilder;
import br.com.alura.humanDev.builders.CourseBuilder;
import br.com.alura.humanDev.builders.SubcategoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseDaoTest {

    private Subcategory subcategory;
    private Category category;
    private CourseDAO coursedao;
    private CategoryDAO categoryDAO;
    private SubcategoryDAO subcategoryDAO;
    private EntityManager em ;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtilTest.getEntityManager();
        this.coursedao = new CourseDAO(em);
        this.categoryDAO = new CategoryDAO(em);
        this.subcategoryDAO = new SubcategoryDAO(em);

        this.category = new CategoryBuilder()
                .withName("Development")
                .withCode("dev")
                .withOrdination(2)
                .withCategoryDescription("course")
                .withActive(true)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
        categoryDAO.insert(category);

        this.subcategory = new SubcategoryBuilder()
                .withName("java")
                .withCode("code")
                .withOrdination(1)
                .withSubcategoryDescription("desc")
                .withActive(true)
                .withCategory(category)
                .create();
       subcategoryDAO.insert(subcategory);
   }

    @AfterEach
    public void afterEach() {
        coursedao.removeAllCourses();
        subcategoryDAO.removeAllSubcategories();
        categoryDAO.removeAllCategories();
    }

    @Test
    void shouldShowPublicCourses() {
        createCourse();
        createCourse2();

        List<Course> courses = this.coursedao.showPublicCourses();

        assertEquals(1, courses.size());
        assertEquals("course-true", courses.get(0).getName());
    }

    @Test
    void shouldUpdateCourseStatusToPublic() {
        createCourse();
        createCourse2();

        List<Course> courses = this.coursedao.updateAllCourseStatusToPublic();

        assertEquals(2, courses.size());
        assertTrue(courses.get(1).isStatus());
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
        coursedao.insert(course);
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
        coursedao.insert(course);
        return course;
    }

}


