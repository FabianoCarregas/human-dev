package br.com.alura.humanDev.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilTest {

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("humantest");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
