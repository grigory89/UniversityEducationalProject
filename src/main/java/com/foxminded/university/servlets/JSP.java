package com.foxminded.university.servlets;

public enum JSP {
    CLASSROOMS ("/classrooms.jsp"),
    FACULTIES("/faculties.jsp"),
    FACULTY("/faculty.jsp"),
    GROUPS("/groups.jsp"),
    GROUP("/group.jsp"),
    LESSONS("/lessons.jsp"),
    STUDENT("/student.jsp"),
    STUDENTS("/students.jsp"),
    SUBJECTS("/subjects.jsp"),
    TEACHERS("/teachers.jsp");

    private final String value;

    JSP(String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}

