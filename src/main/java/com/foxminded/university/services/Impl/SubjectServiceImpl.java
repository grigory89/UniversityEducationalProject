package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.SubjectDao;
import com.foxminded.university.dao.postgres.SubjectDaoPostgres;
import com.foxminded.university.domain.Subject;
import com.foxminded.university.services.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao = new SubjectDaoPostgres();

    @Override
    public void create(Subject subject) {
        subjectDao.create(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject findById (int id) {
        return subjectDao.findById(id);
    }

    @Override
    public void update(Subject subject) {
        subjectDao.update(subject);
    }

    @Override
    public void delete(int id) {
        subjectDao.delete(id);
    }
}
