package com.foxminded.university.servlets;

import com.foxminded.university.domain.Classroom;
import com.foxminded.university.services.ClassroomService;
import com.foxminded.university.services.Impl.ClassroomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/classroom")
public class ClassroomServlet extends HttpServlet {
    private ClassroomService classroomService = new ClassroomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number = Integer.valueOf(req.getParameter("number"));
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroomService.findByNumber(number));
        req.setAttribute("classrooms", classrooms);
        req.getRequestDispatcher(JSP.CLASSROOMS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number = Integer.valueOf(req.getParameter("number"));
        classroomService.delete(number);
        resp.sendRedirect(URL.CLASSROOMS.value());
    }
}
