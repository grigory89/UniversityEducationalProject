package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.dao.TeacherDao;
import com.foxminded.university.domain.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherDaoPostgres implements TeacherDao {
    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Teacher create(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        return teacher;
    }

    @Override
    public Teacher findById(int id) {
        entityManager.getTransaction().begin();
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.getTransaction().commit();
        return teacher;
    }

    @Override
    public List<Teacher> findAll() {
        String query = "select t from Teacher t";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Teacher> teachers = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();

        return teachers;
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.merge(teacher);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
        entityManager.getTransaction().commit();
    }
}
