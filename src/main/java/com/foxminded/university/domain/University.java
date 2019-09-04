package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private List<Faculty> faculties = new ArrayList<>();
    private List<Classroom> classrooms = new ArrayList<>();
    private List<Lesson> schedule = new ArrayList<>();

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public List<Lesson> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Lesson> schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return faculties.equals(that.faculties) &&
                classrooms.equals(that.classrooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties, classrooms);
    }
}
