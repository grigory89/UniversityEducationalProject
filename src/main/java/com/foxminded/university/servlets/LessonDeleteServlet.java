package com.foxminded.university.servlets;

import com.foxminded.university.services.Impl.LessonServiceImpl;
import com.foxminded.university.services.LessonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/lesson/delete")
public class LessonDeleteServlet extends HttpServlet {
    private LessonService lessonService = new LessonServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("lessonId"));
        lessonService.delete(id);
        resp.sendRedirect(URL.LESSONS.value());
    }
}


