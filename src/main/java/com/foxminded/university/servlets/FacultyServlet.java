package com.foxminded.university.servlets;

import com.foxminded.university.domain.Faculty;
import com.foxminded.university.services.FacultyService;
import com.foxminded.university.services.Impl.FacultyServiceImpl;
import com.foxminded.university.services.Impl.SubjectServiceImpl;
import com.foxminded.university.services.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/faculty")
public class FacultyServlet extends HttpServlet {
    private FacultyService facultyService = new FacultyServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int facultyId = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("faculty", facultyService.findById(facultyId));
        req.setAttribute("subjects", subjectService.findAll());
        req.getRequestDispatcher(JSP.FACULTY.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Faculty faculty = new Faculty();
        faculty.setName(req.getParameter("name"));
        int id = Integer.valueOf(req.getParameter("facultyId"));
        faculty.setId(id);
        facultyService.update(faculty);
        resp.sendRedirect(URL.FACULTIES.value());
    }
}
