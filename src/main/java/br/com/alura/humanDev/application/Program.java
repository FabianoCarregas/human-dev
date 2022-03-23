package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;
import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.dao.CourseDAO;
import br.com.alura.humanDev.reports.HtmlReport;
import br.com.alura.humanDev.dao.SubcategoryDAO;

import javax.persistence.EntityManager;

import static br.com.alura.humanDev.util.JPAUtil.getEntityManager;

public class Program {

    public static void main(String[] args) {

        String code = "cour-code";

        Category category = new Category("java", "code-j", 2, "desc",
                true, "http", "#FFF");
        Subcategory subcategory = new Subcategory("sub-name", "code-sub", 3, "desc",
                true, category);
        Course course = new Course("cour-name", "cour-code", 1, false, "target",
                "inst", "desc", "skills", subcategory);

        EntityManager em = getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(em);
        SubcategoryDAO subcategoryDAO = new SubcategoryDAO(em);
        CourseDAO courseDAO = new CourseDAO(em);

//        categoryDAO.insert(category);
//        subcategoryDAO.insert(subcategory);
//        courseDAO.insert(course);
//        courseDAO.deleteCourseByCode(code);
//        courseDAO.updateCourseStatusToPublic();

        HtmlReport.listHtml(categoryDAO, subcategoryDAO, courseDAO);
        em.close();
    }
}