//package br.com.alura.humanDev.dao;
//
//import br.com.alura.humanDev.entities.Category;
//import br.com.alura.humanDev.entities.Subcategory;
//import br.com.alura.humanDev.jpa.JPAUtil;
//import br.com.alura.humanDev.jpa.SubcategoryDAO;
//import br.com.alura.humanDev.jpa.builder.CategoryBuilder;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//
//import javax.persistence.EntityManager;
//
//public class SubcategoryDaoTest {
//
//
//    private Category category;
//    private SubcategoryDAO dao;
//    private EntityManager em ;
//
//    @BeforeEach
//    public void beforeEach() {
//        this.em = JPAUtil.getEntityManager();
//        this.dao = new SubcategoryDAO(em);
//        em.getTransaction().begin();
//
//        this.category = new CategoryBuilder()
//                .withName("Development")
//                .withCode("dev")
//                .withOrdination(2)
//                .withCategoryDescription("course")
//                .withActive(true)
//                .withIcon("http")
//                .withHexaColor("#FFF")
//                .create();
//        em.persist(category);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        em.getTransaction().rollback();
//    }
//
////    private Subcategory createSubcategory()
////    subcategory = new SubcategoryBuilder()
////                .withName("java")
////                .withCode("code")
////                .withOrdination(1)
////                .withSubcategoryDescription("desc")
////                .withActive(true)
////                .withCategory(category)
////                .create();
////        em.persist(subcategory);
//
//
//
//
//
//}
