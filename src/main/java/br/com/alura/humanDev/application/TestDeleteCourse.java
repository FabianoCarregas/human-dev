package br.com.alura.humanDev.application;

import br.com.alura.humanDev.dao.CourseDAO;
import br.com.alura.humanDev.util.JPAUtil;
import javax.persistence.EntityManager;

public class TestDeleteCourse {

    public static void main(String[] args) {

        String code = "cour-code";

        EntityManager em = JPAUtil.getEntityManager();
        CourseDAO courseDAO = new CourseDAO(em);

        courseDAO.deleteCourseByCode(code);

        em.close();
    }
}