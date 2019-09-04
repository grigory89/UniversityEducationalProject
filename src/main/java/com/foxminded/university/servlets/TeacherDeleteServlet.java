package com.foxminded.university.servlets;

import com.foxminded.university.services.Impl.TeacherServiceImpl;
import com.foxminded.university.services.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/teacher/delete")
public class TeacherDeleteServlet extends HttpServlet {

    private TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("teacherId"));
        teacherService.delete(id);
        resp.sendRedirect(JSP.TEACHERS.value());
    }
}
