insert into FACULTIES (NAME)
values ('art'),
       ('science');

insert into SUBJECTS (NAME, FACULTY_ID)
values ('math', 2),
       ('economy', 2),
       ('philosophy', 1),
       ('history', 1),
       ('computers', 2);

insert into TEACHERS (FACULTY_ID, NAME, PHONE_NUMBER, SUBJECT_ID)
values (2, 'Marijo Smullen', '+263-990-807-3846', 1),
       (2, 'Valerie Brockwell','+3-190-112-5569', 2),
       (1, 'Rosabelle Spatari', '+1-359-284-4567', 3),
       (1, 'Gallagher Michelotti', '+45-359-284-5695', 4),
       (2, 'Claudina Manthroppe', '+34-459-246-9095',5);

insert into CLASSROOMS (NUMBER)
VALUES (1),
       (2),
       (3),
       (4);

insert into GROUPS (FACULTY_ID, NAME)
values (1, 'ab19'),
       (2, 'cd19'),
       (2, 'ef19'),
       (1, 'gh18'),
       (1, 'lk18'),
       (2, 'mu18'),
       (1, 'gr18');


insert into STUDENTS (GROUP_ID, NAME, PHONE_NUMBER, ID_CARD)
values (2, 'Myron Giaomozzo', '+359-621-794-4600', 1),
       (4, 'Maurise Healing', '+86-751-754-9988', 2),
       (1, 'Audrye Hartrick', '+7-333-659-9133', 3),
       (2, 'Fremont Scrane', '+63-153-723-1444', 4),
       (3, 'Sheryl Baron', '+371-190-112-5556', 5),
       (3, 'Almire Perrin', '+82-194-292-9909', 6),
       (1, 'Lira Sabattier', '+1-359-284-9095', 7),
       (2, 'Dayna Davidovics', '+30-102-127-1501', 8),
       (1, 'Rodi Hosier', '+54-799-504-0278', 9),
       (7, 'Ruddy Pavese', '+52-472-557-9199', 10),
       (6, 'Fancy Dullingham', '+385-447-363-4475', 11),
       (4, 'Craggy Presho', '+263-990-807-3846', 12),
       (1, 'Price Klaggeman', '+234-836-762-1412', 13),
       (5, 'Clint Lannen', '+86-619-311-8646', 14);

insert into LESSONS (DATE_TIME, SUBJECT_ID, CLASSROOM, TEACHER_ID)
values ('2019-10-19 10:00:00', 1, 2, 1);

insert into LESSONS_GROUPS (LESSON_ID, GROUP_ID)
values (1, 2),
       (1, 1);
