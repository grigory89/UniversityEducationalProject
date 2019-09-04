package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.FacultyDao;
import com.foxminded.university.dao.postgres.FacultyDaoPostgres;
import com.foxminded.university.domain.Faculty;
import com.foxminded.university.services.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    private FacultyDao facultyDao = new FacultyDaoPostgres();

    @Override
    public void create (Faculty faculty) {
        facultyDao.create(faculty);
    }

    @Override
    public List<Faculty> findAll () {
        return facultyDao.findAll();
    }

    @Override
    public Faculty findById (int id) {
        return facultyDao.findById(id);
    }

    @Override
    public void update(Faculty faculty) {
        facultyDao.update(faculty);
    }

    @Override
    public void delete(int id) {
        facultyDao.delete(id);
    }
}
