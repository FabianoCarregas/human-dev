package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {

        Category category = new Category(1L, "java", "code", "desc", "guide", true, 2, "http", "#FFF");
        Subcategory subcategory = new Subcategory(null,"ja", "ja", 1, "na", true, category);
        Course course = new Course(null, "ba", "ba", 1, true, "gga", "haha", "bom", "kaka", subcategory);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("humanDev");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.persist(subcategory);
        em.persist(course);
        em.getTransaction().commit();
        em.close();

    }
}