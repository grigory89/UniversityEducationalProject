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

@WebServlet(urlPatterns = "/teachers")
public class TeachersServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("teachers", teacherService.findAll());
        req.setAttribute("subjects", subjectService.findAll());
        req.getRequestDispatcher(JSP.TEACHERS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        teacher.setName(req.getParameter("name"));
        int subjectId = Integer.valueOf(req.getParameter("subjectId"));
        teacher.setSubject(subjectService.findById(subjectId));
        teacherService.create(teacher);
        resp.sendRedirect(URL.TEACHERS.value());
    }
}
