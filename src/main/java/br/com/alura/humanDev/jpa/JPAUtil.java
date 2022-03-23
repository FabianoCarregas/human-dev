package br.com.alura.humanDev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    public static EntityManager getEntityManager() {
        EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("humanDev");
        return FACTORY.createEntityManager();
    }

    public static EntityManager getEntityManagerTest() {
        EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("humantest");
        return FACTORY.createEntityManager();
    }

}
