package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.dao.FacultyDao;
import com.foxminded.university.domain.Faculty;

import javax.persistence.EntityManager;
import java.util.List;

public class FacultyDaoPostgres implements FacultyDao {
    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Faculty create(Faculty faculty) {
        entityManager.getTransaction().begin();
        entityManager.persist(faculty);
        entityManager.getTransaction().commit();
        return faculty;
    }

    @Override
    public Faculty findById(int id) {
        entityManager.getTransaction().begin();
        Faculty faculty = entityManager.find(Faculty.class, id);
        entityManager.getTransaction().commit();
        return faculty;
    }

    @Override
    public List<Faculty> findAll() {
        String query = "select f from Faculty f";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Faculty> faculties = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();
        return faculties;
    }

    @Override
    public void update(Faculty faculty) {
        entityManager.getTransaction().begin();
        entityManager.merge(faculty);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Faculty faculty = entityManager.find(Faculty.class, id);
        entityManager.remove(faculty);
        entityManager.getTransaction().commit();
    }
}
