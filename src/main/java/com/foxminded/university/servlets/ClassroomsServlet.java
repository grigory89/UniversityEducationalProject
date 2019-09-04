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

@WebServlet(urlPatterns = "/classrooms")
public class ClassroomsServlet extends HttpServlet {
    private ClassroomService classroomService = new ClassroomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("classrooms", classroomService.findAll());
        req.getRequestDispatcher(JSP.CLASSROOMS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Classroom classroom = new Classroom();
        int number = Integer.valueOf(req.getParameter("number"));
        classroom.setRoomNumber(number);
        classroomService.create(classroom);
        resp.sendRedirect(URL.CLASSROOMS.value());
    }
}
