package com.foxminded.university.servlets;

import com.foxminded.university.domain.Student;
import com.foxminded.university.services.Impl.GroupServiceImpl;
import com.foxminded.university.services.Impl.StudentServiceImpl;
import com.foxminded.university.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private GroupServiceImpl groupsService = new GroupServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("student", studentService.findById(id));
        req.setAttribute("groups", groupsService.findAll());
        req.getRequestDispatcher(JSP.STUDENT.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setName(req.getParameter("name"));
        student.setPhoneNumber(req.getParameter("phoneNumber"));
        student.setIdCard(Integer.valueOf(req.getParameter("idCard")));
        student.setId(Integer.valueOf(req.getParameter("studentId")));
        studentService.update(student);
        if (req.getParameterMap().containsKey("groupId")) {
            int groupId = Integer.valueOf(req.getParameter("groupId"));
            studentService.moveToGroup(student, groupId);
        }
        resp.sendRedirect(URL.STUDENTS.value());
    }
}
