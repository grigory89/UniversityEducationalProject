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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/subject")
public class SubjectServlet extends HttpServlet {
    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subjectService.findById(id));
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher(JSP.SUBJECTS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject subject = new Subject();
        subject.setName(req.getParameter("name"));
        int id = Integer.valueOf(req.getParameter("subjectId"));
        subject.setId(id);
        subjectService.update(subject);
        resp.sendRedirect(URL.SUBJECTS.value());
    }
}
