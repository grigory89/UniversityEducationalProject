package com.foxminded.university.servlets;

import com.foxminded.university.services.FacultyService;
import com.foxminded.university.services.Impl.FacultyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/faculty/delete")
public class FacultyDeleteServlet extends HttpServlet {
    private FacultyService facultyService = new FacultyServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           int id = Integer.valueOf(req.getParameter("facultyId"));
           facultyService.delete(id);
           resp.sendRedirect(URL.FACULTIES.value());
    }
}
