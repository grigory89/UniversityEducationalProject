package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.TeacherDao;
import com.foxminded.university.dao.postgres.TeacherDaoPostgres;
import com.foxminded.university.domain.Teacher;
import com.foxminded.university.services.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoPostgres();

    @Override
    public void create(Teacher teacher) {
        teacherDao.create(teacher);
    }

    @Override
    public List<Teacher> findAll () {
        return teacherDao.findAll();
    }

    @Override
    public Teacher findById (int id) {
        return teacherDao.findById(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public void delete(int id) {
        teacherDao.delete(id);
    }
}
