package com.foxminded.university.servlets;

import com.foxminded.university.domain.Student;
import com.foxminded.university.services.Impl.StudentServiceImpl;
import com.foxminded.university.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/students")
public class StudentsServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", studentService.findAll());
        req.getRequestDispatcher(JSP.STUDENTS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setName(req.getParameter("name"));
        student.setPhoneNumber(req.getParameter("phoneNumber"));
        student.setIdCard(Integer.valueOf(req.getParameter("idCard")));
        studentService.createStudent(student);
        resp.sendRedirect(URL.STUDENTS.value());
    }
}
