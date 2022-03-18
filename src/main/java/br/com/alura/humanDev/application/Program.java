package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.jpa.CategoryDAO;
import br.com.alura.humanDev.jpa.CourseDAO;
import br.com.alura.humanDev.jpa.JPAUtil;
import br.com.alura.humanDev.jpa.SubcategoryDAO;

import javax.persistence.EntityManager;

public class Program {

    public static void main(String[] args) {

        Category category = new Category(null, "java", "code", "desc", "guide", true, 2, "http", "#FFF");
        Subcategory subcategory = new Subcategory(null,"name", "code", "desc", "guide", true, 3, category);
        Course course = new Course(null,"name", "code", 1, true, "target", "inst", "desc", "skills", subcategory);

        EntityManager em = JPAUtil.getEntityManager();

        CategoryDAO categoryDAO = new CategoryDAO(em);
        SubcategoryDAO subcategoryDAO = new SubcategoryDAO(em);
        CourseDAO courseDAO = new CourseDAO(em);

        em.getTransaction().begin();

        categoryDAO.insert(category);
        subcategoryDAO.insert(subcategory);
        courseDAO.insert(course);

        em.getTransaction().commit();
        em.close();

    }
}