package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;
import br.com.alura.humanDev.builders.CategoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryDaoTest {

    private CategoryDAO dao;
    private EntityManager em ;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManagerTest();
        this.dao = new CategoryDAO(em);
    }

    @AfterEach
    public void afterEach() {
        dao.removeAllCategories();
    }

    @Test
    void shouldShowActiveCategoriesByOrder() {
        createCategory();
        createCategory2();
        List<Category> categories = this.dao.showActiveCategoriesByOrder();

        assertEquals(2, categories.size());
        assertEquals("Development", categories.get(0).getName());
        assertEquals("Development1", categories.get(1).getName());
    }

    private Category createCategory() {
        Category category = new CategoryBuilder()
                .withName("Development")
                .withCode("dev")
                .withOrdination(2)
                .withCategoryDescription("course")
                .withActive(true)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
        dao.insert(category);
        return category;
    }

    private Category createCategory2() {
        Category category = new CategoryBuilder()
                .withName("Development1")
                .withCode("dev")
                .withOrdination(4)
                .withCategoryDescription("course")
                .withActive(true)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
        dao.insert(category);
        return category;
    }

}
