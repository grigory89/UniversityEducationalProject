package com.foxminded.university.servlets;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Lesson;
import com.foxminded.university.services.ClassroomService;
import com.foxminded.university.services.Impl.ClassroomServiceImpl;
import com.foxminded.university.services.Impl.GroupServiceImpl;
import com.foxminded.university.services.Impl.LessonServiceImpl;
import com.foxminded.university.services.Impl.SubjectServiceImpl;
import com.foxminded.university.services.LessonService;
import com.foxminded.university.services.SubjectService;
import com.foxminded.university.services.Impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/lesson")
public class LessonServlet extends HttpServlet {
    private LessonService lessonService = new LessonServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    private TeacherServiceImpl teacherService = new TeacherServiceImpl();
    private ClassroomService classroomService = new ClassroomServiceImpl();
    private GroupServiceImpl groupsService = new GroupServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("teacherId"));
        List<Lesson> lessons = lessonService.findByTeacher(id);
        req.setAttribute("lessons", lessons);
        req.setAttribute("subjects", subjectService.findAll());
        req.setAttribute("teachers", teacherService.findAll());
        req.setAttribute("classrooms", classroomService.findAll());
        req.setAttribute("groups", groupsService.findAll());

        req.getRequestDispatcher(JSP.LESSONS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Lesson lesson = new Lesson();
        LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("date"));
        List<Group> groups = new ArrayList<>();
        String[] groupsId = req.getParameterValues("groups");
        List<Integer> ids = Arrays.stream(groupsId).map(Integer::valueOf).collect(Collectors.toList());
        ids.forEach(id -> groups.add(groupsService.findById(id)));
        int teacherId = Integer.valueOf(req.getParameter("teacher"));
        int subjectId = Integer.valueOf(req.getParameter("subject"));
        int roomNumber = Integer.valueOf(req.getParameter("classroom"));
        lesson.setDateTime(dateTime);
        lesson.setTeacher(teacherService.findById(teacherId));
        lesson.setSubject(subjectService.findById(subjectId));
        lesson.setClassroom(classroomService.findByNumber(roomNumber));
        lesson.setGroups(groups);
        int lessonId = Integer.valueOf(req.getParameter("lessonId"));
        lesson.setId(lessonId);
        lessonService.update(lesson);
        resp.sendRedirect(URL.LESSONS.value());
    }
}
