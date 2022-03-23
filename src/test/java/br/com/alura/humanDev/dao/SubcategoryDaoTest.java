package br.com.alura.humanDev.dao;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.util.JPAUtil;
import br.com.alura.humanDev.builders.CategoryBuilder;
import br.com.alura.humanDev.builders.SubcategoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubcategoryDaoTest {

    private Category category;
    private SubcategoryDAO dao;
    private CategoryDAO categoryDAOdao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManagerTest();
        this.dao = new SubcategoryDAO(em);

        this.category = new CategoryBuilder()
                .withName("Development")
                .withCode("dev")
                .withOrdination(2)
                .withCategoryDescription("course")
                .withActive(true)
                .withIcon("http")
                .withHexaColor("#FFF")
                .create();
        categoryDAOdao.insert(category);
    }

    @AfterEach
    public void afterEach() {
        dao.removeAllSubcategories();
    }

    @Test
    void shouldShowSubcategoriesWithoutDescription() {
        createSubcategory();
        createSubcategory2();

        List<String> subcategories = this.dao.showSubcategoriesWithoutDescription();

        assertEquals("java2", subcategories.get(0));
        assertEquals(1, subcategories.size());
    }

    @Test
    void shouldShowActiveSubcategoriesByOrder() {
        createSubcategory();
        createSubcategory2();

        List<Subcategory> subcategories = this.dao.showActiveSubcategoriesByOrder();

        assertEquals(2, subcategories.size());
        assertEquals("java", subcategories.get(0).getName());
        assertEquals("java2", subcategories.get(1).getName());
    }

    private Subcategory createSubcategory() {
        Subcategory subcategory = new SubcategoryBuilder()
                .withName("java")
                .withCode("code")
                .withOrdination(1)
                .withSubcategoryDescription("desc")
                .withActive(true)
                .withCategory(category)
                .create();
        dao.insert(subcategory);
        return subcategory;
    }

    private Subcategory createSubcategory2() {
        Subcategory subcategory = new SubcategoryBuilder()
                .withName("java2")
                .withCode("code")
                .withOrdination(2)
                .withSubcategoryDescription("")
                .withActive(true)
                .withCategory(category)
                .create();
        dao.insert(subcategory);
        return subcategory;
    }
}
