package com.foxminded.university.servlets;

public enum URL {
    CLASSROOMS ("/classrooms"),
    FACULTIES("/faculties"),
    FACULTY("/faculty"),
    SUBJECTS("/subjects"),
    SUBJECT("/subject"),
    TEACHERS("/teachers"),
    TEACHER("/teacher"),
    STUDENTS("/students"),
    STUDENT("/student"),
    LESSONS("/lessons"),
    LESSON("/lesson"),
    GROUPS("/groups"),
    GROUP("/group");

    private final String value;

    URL(String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }
}
