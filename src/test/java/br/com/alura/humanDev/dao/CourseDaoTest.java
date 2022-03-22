package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.jpa.CourseDAO;
import br.com.alura.humanDev.jpa.JPAUtil;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDaoTest {


    Category category = new Category(null, "java", "code", "desc", "guide", true, 2, "http", "#FFF");
    Subcategory subcategory = new Subcategory(null,"name", "code", "desc", "guide", true, 3, category);
    Course course = new Course(null,"name", "code", 1, true, "target", "inst", "desc", "skills", subcategory);

    private CourseDAO dao;
    private EntityManager em ;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new CourseDAO(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    void shouldShowPublicCourses() {
        em.persist(category);

        List<Course> courses = dao.showPublicCourses();
        Assertions.assertNotNull(courses);
    }

    @Test
    void shouldUpdateCourseStatusToPublic() {
        em.persist(category);

        dao.updateCourseStatusToPublic();
        Assertions.assertNotNull(course);
    }

}
