package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.dao.SubjectDao;
import com.foxminded.university.domain.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class SubjectDaoPostgres implements SubjectDao {
    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Subject create(Subject subject) {
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.getTransaction().commit();
        return subject;
    }

    @Override
    public Subject findById(int id) {
        entityManager.getTransaction().begin();
        Subject subject = entityManager.find(Subject.class, id);
        entityManager.getTransaction().commit();
        return subject;
    }

    @Override
    public List<Subject> findAll() {
        String query = "select s from Subject s";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Subject> subjects = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();
        return subjects;
    }

    @Override
    public void update(Subject subject) {
        entityManager.getTransaction().begin();
        entityManager.merge(subject);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Subject subject = entityManager.find(Subject.class, id);
        entityManager.remove(subject);
        entityManager.getTransaction().commit();
    }
}
