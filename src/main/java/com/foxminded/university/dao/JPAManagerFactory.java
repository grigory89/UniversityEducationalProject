package com.foxminded.university.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAManagerFactory {
    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("persistence");
    }

    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
}