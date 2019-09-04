package com.foxminded.university.services;

import com.foxminded.university.domain.Student;
import java.util.List;

public interface StudentService {
     Student createStudent (Student student);

     List<Student> findAll();

     Student findById (int id);

     void moveToGroup (Student student, int groupId);

     void update (Student student);

     void delete (int id);
}
