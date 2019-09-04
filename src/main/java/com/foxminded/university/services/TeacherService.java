package com.foxminded.university.services;

import com.foxminded.university.domain.Teacher;

import java.util.List;

public interface TeacherService {
     void create (Teacher teacher);

     List<Teacher> findAll ();

     Teacher findById (int id);

     void update(Teacher teacher);

     void delete (int id);
}
