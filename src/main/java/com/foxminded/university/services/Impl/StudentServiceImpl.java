package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.dao.postgres.GroupDaoPostgres;
import com.foxminded.university.dao.postgres.StudentDaoPostgres;
import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.services.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoPostgres();
    private GroupDao groupDao = new GroupDaoPostgres();

    @Override
    public Student createStudent (Student student) {
        return studentDao.create(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById (int id) {
        return studentDao.findById(id);
    }

    @Override
    public void update (Student student) {
        studentDao.update(student);
    }

    @Override
    public void moveToGroup (Student student, int groupId) {
        Group group = groupDao.findById(groupId);
        group.getStudents().add(student);
        groupDao.update(group);
    }

    @Override
    public void delete (int id) {
        studentDao.delete(id);
    }
}
