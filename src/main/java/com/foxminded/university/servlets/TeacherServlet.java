package com.foxminded.university.servlets;

import com.foxminded.university.domain.Teacher;
import com.foxminded.university.services.Impl.SubjectServiceImpl;
import com.foxminded.university.services.Impl.TeacherServiceImpl;
import com.foxminded.university.services.SubjectService;
import com.foxminded.university.services.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/teacher")
public class TeacherServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacherService.findById(id));
        req.setAttribute("teachers", teachers);
        req.setAttribute("subjects", subjectService.findAll());
        req.getRequestDispatcher(JSP.TEACHERS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        teacher.setName(req.getParameter("name"));
        int subjectId = Integer.valueOf(req.getParameter("subjectId"));
        teacher.setSubject(subjectService.findById(subjectId));
        teacher.setId(Integer.valueOf(req.getParameter("teacherId")));
        teacherService.update(teacher);
        resp.sendRedirect(URL.TEACHER.value());
    }
}
