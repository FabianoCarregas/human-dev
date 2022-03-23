package br.com.alura.humanDev.application;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.dao.CourseDAO;
import br.com.alura.humanDev.dao.SubcategoryDAO;
import br.com.alura.humanDev.reports.HtmlReport;
import br.com.alura.humanDev.util.JPAUtil;

import javax.persistence.EntityManager;


public class TestHtmlReport {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(em);
        SubcategoryDAO subcategoryDAO = new SubcategoryDAO(em);
        CourseDAO courseDAO = new CourseDAO(em);


        HtmlReport.listHtml(categoryDAO, subcategoryDAO, courseDAO);
        em.close();
    }
}