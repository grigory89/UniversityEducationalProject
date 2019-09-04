package com.foxminded.university.services;

import com.foxminded.university.domain.Subject;

import java.util.List;

public interface SubjectService {
     void create(Subject subject);

     List<Subject> findAll ();

     Subject findById (int id);

     void update(Subject subject);

     void delete(int id);
}
