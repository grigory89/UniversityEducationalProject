package com.foxminded.university.dao;

import com.foxminded.university.domain.Lesson;

import java.util.List;

public interface LessonDao extends CrudDao<Lesson> {
    List<Lesson> findByTeacher(int teacherId);
}
