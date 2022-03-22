package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import javax.persistence.EntityManager;
import java.util.List;

public class SubcategoryDAO {

    private EntityManager em;

    public SubcategoryDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Subcategory subcategory) {
        this.em.persist(subcategory);
    }

    public List<Subcategory> showActiveSubcategoriesByOrder() {
        String jpql = "SELECT s FROM Subcategory s WHERE s.active = true ORDER BY s.ordination";
        return em.createQuery(jpql, Subcategory.class)
                .getResultList();
    }

    public List<String> showSubcategoriesWithoutDescription() {
        String jpql = "SELECT s.name FROM Subcategory s WHERE s.subcategoryDescription = ''";
        return em.createQuery(jpql, String.class)
                .getResultList();
    }

}
