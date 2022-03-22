package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.jpa.CategoryDAO;
import br.com.alura.humanDev.jpa.CourseDAO;
import br.com.alura.humanDev.jpa.HtmlReport;
import br.com.alura.humanDev.jpa.SubcategoryDAO;

import javax.persistence.EntityManager;

import static br.com.alura.humanDev.jpa.JPAUtil.getEntityManager;

public class Program {

    public static void main(String[] args) {

        String code = "code";

        Category category = new Category("java", "code", 2, "desc",
                true, "http", "#FFF");
        Subcategory subcategory = new Subcategory("name", "code", 3, "desc",
                true, category);
        Course course = new Course("name", "code", 1, false, "target",
                "inst", "desc", "skills", subcategory);

        EntityManager em = getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(em);
        SubcategoryDAO subcategoryDAO = new SubcategoryDAO(em);
        CourseDAO courseDAO = new CourseDAO(em);


        em.getTransaction().begin();
       categoryDAO.insert(category);
//        subcategoryDAO.insert(subcategory);
//        courseDAO.insert(course);
//        courseDAO.deleteCourseByCode(code);
//        courseDAO.updateCourseStatusToPublic();

        HtmlReport.listHtml(categoryDAO, subcategoryDAO, courseDAO);
        em.getTransaction().commit();
        em.close();

    }
}