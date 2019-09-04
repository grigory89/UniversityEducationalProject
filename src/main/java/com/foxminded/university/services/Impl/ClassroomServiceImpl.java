package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.ClassroomDao;
import com.foxminded.university.dao.postgres.ClassroomDaoPostgres;
import com.foxminded.university.domain.Classroom;
import com.foxminded.university.services.ClassroomService;

import java.util.List;

public class ClassroomServiceImpl implements ClassroomService {
    private ClassroomDao classroomDao = new ClassroomDaoPostgres();

    @Override
    public void create(Classroom classroom) {
        classroomDao.create(classroom);
    }

    @Override
    public List<Classroom> findAll () {
        return classroomDao.findAll();
    }

    @Override
    public Classroom findByNumber(int number) {
        return classroomDao.findByNumber(number);
    }

    @Override
    public void delete(int number) {
        classroomDao.delete(number);
    }
}
