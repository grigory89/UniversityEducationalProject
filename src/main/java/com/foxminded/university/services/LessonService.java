package com.foxminded.university.services;

import com.foxminded.university.domain.Lesson;

import java.util.List;

public interface LessonService {
    void create(Lesson lesson);

    List<Lesson> findAll ();

    Lesson findById(int id);

    List<Lesson> findByTeacher(int teacherId);

    void update (Lesson lesson);

    void delete(int id);
}
