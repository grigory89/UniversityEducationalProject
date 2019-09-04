package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.domain.Student;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import javax.persistence.EntityManager;

public class StudentDaoPostgres implements StudentDao {
    private static final Logger log = LogManager.getLogger(StudentDaoPostgres.class);

    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Student create(Student student) {
        log.debug("Creating new {}", student);
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;

    }

    @Override
    public Student findById(int id) {
        log.debug("Finding student with id={}", id);
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public List<Student> findAll() {
        log.debug("Finding all students");
        String query = "select s from Student s";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Student> students = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();
        return students;
    }

    @Override
    public void update(Student student) {
        log.debug("Updating {}", student);
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        log.debug("Deleting student with id={}", id);
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
