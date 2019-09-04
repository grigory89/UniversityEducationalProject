package com.foxminded.university.servlets;

import com.foxminded.university.services.Impl.SubjectServiceImpl;
import com.foxminded.university.services.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/subject/delete")
public class SubjectDeleteServlet extends HttpServlet {
    private static final String SUBJECTS = "/subjects";

    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("subjectId"));
        subjectService.delete(id);
        resp.sendRedirect(URL.SUBJECTS.value());
    }
}
