package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.dao.LessonDao;
import com.foxminded.university.domain.Lesson;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonDaoPostgres implements LessonDao {
    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Lesson create(Lesson lesson) {
        entityManager.getTransaction().begin();
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        return lesson;
    }

    @Override
    public Lesson findById(int id) {
        entityManager.getTransaction().begin();
        Lesson lesson =  entityManager.find(Lesson.class, id);
        entityManager.getTransaction().commit();
        return lesson;
    }

    @Override
    public List<Lesson> findAll() {
        String query = "select l from Lesson l";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Lesson> lessons = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();
        return lessons;
    }

    @Override
    public List<Lesson> findByTeacher(int teacherId) {
        String query = "select l from Lesson l where l.teacher.id = :id";
        entityManager.getTransaction().begin();
        List<Lesson> lessons = entityManager
                .createQuery(query)
                .setParameter("id", teacherId)
                .getResultList();
        entityManager.getTransaction().commit();
        return lessons;
    }

    @Override
    public void update(Lesson lesson) {
        entityManager.getTransaction().begin();
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.remove(lesson);
        entityManager.getTransaction().commit();
    }
}
