package com.foxminded.university.dao.postgres;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.dao.JPAManagerFactory;
import com.foxminded.university.domain.Group;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.persistence.EntityManager;

public class GroupDaoPostgres implements GroupDao {
    private static final Logger log = LogManager.getLogger(GroupDao.class);

    private EntityManager entityManager = JPAManagerFactory.getEntityManager();

    @Override
    public Group create(Group group) {
        log.debug("Creating new {}", group);
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
        return group;
    }

    @Override
    public Group findById(int id) {
        log.debug("Finding group with id={}", id);
        entityManager.getTransaction().begin();
        Group group = entityManager.find(Group.class, id);
        entityManager.getTransaction().commit();
        return group;
    }

    @Override
    public List<Group> findAll() {
        log.debug("Finding all groups");
        String query = "select g from Group g";
        entityManager.getTransaction().begin();
        entityManager.clear();
        List<Group> groups = entityManager
                .createQuery(query)
                .getResultList();
        entityManager.getTransaction().commit();
        return groups;
    }


    @Override
    public void update(Group group) {
        log.debug("Updating {}", group);
        entityManager.getTransaction().begin();
        entityManager.merge(group);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        log.debug("Deleting group with id={}", id);
        entityManager.getTransaction().begin();
        Group group = entityManager.find(Group.class, id);
        entityManager.remove(group);
        entityManager.getTransaction().commit();
    }
}
