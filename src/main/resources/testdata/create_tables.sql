create table FACULTIES (
    ID serial not null primary key,
    NAME varchar(50) not null
);

create table SUBJECTS (
    ID serial not null primary key,
    NAME varchar(50) not null,
    FACULTY_ID int references FACULTIES(ID) on delete cascade
);

create table TEACHERS (
    ID serial not null primary key,
    FACULTY_ID int references FACULTIES(ID) on delete cascade,
    NAME varchar(50) not null,
    PHONE_NUMBER varchar(50),
    SUBJECT_ID int references SUBJECTS(ID) on delete cascade
);

create table CLASSROOMS (
    NUMBER int not null primary key
);

create table GROUPS (
    ID serial not null primary key,
    FACULTY_ID int references FACULTIES (ID) on delete cascade,
    NAME varchar(50) not null unique
);

create table STUDENTS (
    ID serial not null primary key,
    GROUP_ID int references GROUPS (ID) on delete cascade,
    NAME varchar(50) not null,
    PHONE_NUMBER varchar(50) not null unique,
    ID_CARD int not null unique
);

create table LESSONS (
    ID serial not null primary key,
    DATE_TIME timestamp not null,
    SUBJECT_ID int references SUBJECTS(ID) not null,
    CLASSROOM int references CLASSROOMS(NUMBER) not null,
    TEACHER_ID int references TEACHERS(ID) not null
);

create table LESSONS_GROUPS (
    LESSON_ID int not null references LESSONS(ID) on delete cascade,
    GROUP_ID int not null references GROUPS(ID) on delete cascade
);
