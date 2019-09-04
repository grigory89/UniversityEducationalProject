package com.foxminded.university.servlets;

import com.foxminded.university.services.Impl.StudentServiceImpl;
import com.foxminded.university.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        studentService.delete(id);
        resp.sendRedirect(URL.STUDENTS.value());
    }
}
