package com.foxminded.university.services;

import com.foxminded.university.domain.Classroom;

import java.util.List;

public interface ClassroomService {
    void create(Classroom classroom);

    List<Classroom> findAll();

    Classroom findByNumber(int number);

    void delete(int number);
}
