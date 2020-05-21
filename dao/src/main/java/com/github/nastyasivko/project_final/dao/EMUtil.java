package com.github.nastyasivko.project_final.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
    private static EntityManagerFactory emFactory = null;

    public static EntityManager getEntityManager(String name) {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory(name);
        }
        return emFactory.createEntityManager();
    }

    public static Session getSession(String name) {
        return getEntityManager(name).unwrap(Session.class);
    }

    public static void closeEMFactory() {
        emFactory.close();
    }
}
