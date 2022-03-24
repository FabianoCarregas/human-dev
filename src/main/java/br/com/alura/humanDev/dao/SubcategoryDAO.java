package br.com.alura.humanDev.dao;

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
        try {
            this.em.getTransaction().begin();
            String jpql = "SELECT s FROM Subcategory s WHERE s.active = true ORDER BY s.ordination";
            List<Subcategory> subcategories = em.createQuery(jpql, Subcategory.class)
                    .getResultList();
            this.em.getTransaction().commit();
            return subcategories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> showSubcategoriesWithoutDescription() {
        try {
            this.em.getTransaction().begin();
            String jpql = "SELECT s.name FROM Subcategory s WHERE s.subcategoryDescription = ''";
            List<String> subcategories = em.createQuery(jpql, String.class)
                    .getResultList();
            this.em.getTransaction().commit();
            return subcategories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void removeAllSubcategories() {
        String jpql = "DELETE FROM Subcategory";
        try {
            em.getTransaction().begin();
            em.createQuery(jpql).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
