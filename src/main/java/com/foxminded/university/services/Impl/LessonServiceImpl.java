package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.LessonDao;
import com.foxminded.university.dao.postgres.LessonDaoPostgres;
import com.foxminded.university.domain.Lesson;
import com.foxminded.university.services.LessonService;
import com.foxminded.university.services.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonDao lessonDao = new LessonDaoPostgres();

    @Override
    public void create(Lesson lesson) {
        if (isNotStudyTime(lesson.getDateTime())) {
            throw new ServiceException("It's not study time");
        }
        if (isNotValidSubject(lesson)) {
            throw new ServiceException("Teacher doesn't know this subject");
        }
        if (hasDuplicate(lesson)) {
            throw new ServiceException("Lesson already exists");
        }
        lessonDao.create(lesson);
    }

    @Override
    public List<Lesson> findAll () {
        return lessonDao.findAll();
    }

    @Override
    public Lesson findById(int id) {
        return lessonDao.findById(id);
    }

    @Override
    public List<Lesson> findByTeacher(int teacherId) {
        return lessonDao.findByTeacher(teacherId);
    }

    @Override
    public void update (Lesson lesson){
        if (isNotStudyTime(lesson.getDateTime())) {
            throw new ServiceException("It's not study time");
        }
        if (isNotValidSubject(lesson)) {
            throw new ServiceException("Teacher doesn't know this subject");
        }
        lessonDao.update(lesson);
    }

    @Override
    public void delete(int id) {
        lessonDao.delete(id);
    }

    private boolean isNotStudyTime(LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        return !(hour > 7 && hour < 22);
    }

    private boolean isNotValidSubject (Lesson lesson) {
        return !(lesson.getTeacher().getSubject().equals(lesson.getSubject()));
    }

    private boolean hasDuplicate(Lesson lesson) {
        lessonDao.findAll();
        return lessonDao.findAll().contains(lesson);
    }
}
