package com.foxminded.university.servlets;

import com.foxminded.university.domain.Subject;
import com.foxminded.university.services.Impl.SubjectServiceImpl;
import com.foxminded.university.services.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/subjects")
public class SubjectsServlet extends HttpServlet {
    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("subjects", subjectService.findAll());
        req.getRequestDispatcher(JSP.SUBJECTS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject subject = new Subject();
        subject.setName(req.getParameter("name"));
        subjectService.create(subject);
        resp.sendRedirect(URL.SUBJECTS.value());
    }
}
