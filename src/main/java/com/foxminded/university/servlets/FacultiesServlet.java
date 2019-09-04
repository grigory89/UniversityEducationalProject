package com.foxminded.university.servlets;

import com.foxminded.university.domain.Faculty;
import com.foxminded.university.services.FacultyService;
import com.foxminded.university.services.Impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/faculties")
public class FacultiesServlet extends HttpServlet {
    private FacultyService facultyService = new FacultyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("faculties", facultyService.findAll());
        req.getRequestDispatcher(JSP.FACULTIES.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Faculty faculty = new Faculty();
        faculty.setName(req.getParameter("name"));
        facultyService.create(faculty);
        resp.sendRedirect(URL.FACULTIES.value());
    }
}
