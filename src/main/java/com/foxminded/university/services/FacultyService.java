package com.foxminded.university.services;

import com.foxminded.university.domain.Faculty;

import java.util.List;

public interface FacultyService {
    void create(Faculty faculty);

    List<Faculty> findAll();

    Faculty findById(int id);

    void update(Faculty faculty);

    void delete(int id);
}
