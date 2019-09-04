package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.ClassroomDao;
import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.domain.Classroom;

import javax.persistence.EntityManager;
import java.util.List;

public class ClassroomDaoPostgres implements ClassroomDao {
    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Classroom create(Classroom classroom) {
        entityManager.getTransaction().begin();
        entityManager.persist(classroom);
        entityManager.getTransaction().commit();
        return classroom;
    }

    @Override
    public Classroom findByNumber(int number) {
        entityManager.getTransaction().begin();
        Classroom classroom = entityManager.find(Classroom.class, number);
        entityManager.getTransaction().commit();
        return classroom;
    }

    @Override
    public List<Classroom> findAll() {
        String query = "select c from Classroom c";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Classroom> classrooms = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();
        return classrooms;
    }

    @Override
    public void delete(int number) {
        entityManager.getTransaction().begin();
        Classroom classroom = entityManager.find(Classroom.class, number);
        entityManager.remove(classroom);
        entityManager.getTransaction().commit();
    }
}
