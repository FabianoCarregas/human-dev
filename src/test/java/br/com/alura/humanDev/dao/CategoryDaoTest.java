//package br.com.alura.humanDev.dao;
//
//import br.com.alura.humanDev.entities.Category;
//import br.com.alura.humanDev.entities.Course;
//import br.com.alura.humanDev.jpa.CategoryDAO;
//import br.com.alura.humanDev.jpa.JPAUtil;
//import br.com.alura.humanDev.jpa.builder.CategoryBuilder;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//public class CategoryDaoTest {
//
//    private CategoryDAO dao;
//    private EntityManager em ;
//
//    @BeforeEach
//    public void beforeEach() {
//        this.em = JPAUtil.getEntityManager();
//        this.dao = new CategoryDAO(em);
//        em.getTransaction().begin();
//    }
//
//    @AfterEach
//    public void afterEach() {
//        em.getTransaction().rollback();
//    }
//
//    private Category createCategory() {
//        Category category = new CategoryBuilder()
//                .withName("Development")
//                .withCode("dev")
//                .withOrdination(2)
//                .withCategoryDescription("course")
//                .withActive(true)
//                .withIcon("http")
//                .withHexaColor("#FFF")
//                .create();
//        em.persist(category);
//
//        return category;
//    }
//
////    @Test
////    void shouldShowActiveCategoriesByOrder() {
////        createCategory();
////        this.dao.showActiveCategoriesByOrder();
////        List<Category> categories = this.dao.findAllCourses();
////
////        Assertions.assertEquals(1, courses.size());
////        Assertions.assertEquals(courses.get(0), createCourse().getClass());
////    }
//
//}
