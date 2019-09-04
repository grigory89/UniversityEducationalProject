package com.foxminded.university.dao;

import com.foxminded.university.domain.Classroom;

import java.util.List;

public interface ClassroomDao {
    Classroom create(Classroom classroom);

    Classroom findByNumber(int number);

    List<Classroom> findAll();

    void delete(int number);
}
