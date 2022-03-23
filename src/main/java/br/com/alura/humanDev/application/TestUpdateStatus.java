package br.com.alura.humanDev.application;

import br.com.alura.humanDev.dao.CourseDAO;
import br.com.alura.humanDev.util.JPAUtil;
import javax.persistence.EntityManager;

public class TestUpdateStatus {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        CourseDAO courseDAO = new CourseDAO(em);

        courseDAO.updateAllCourseStatusToPublic();

        em.close();
    }
}