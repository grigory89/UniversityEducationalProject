package com.foxminded.university.servlets;

import com.foxminded.university.domain.Group;
import com.foxminded.university.services.GroupService;
import com.foxminded.university.services.Impl.GroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/groups")
public class GroupsServlet extends HttpServlet {
    private GroupService groupService = new GroupServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("groups", groupService.findAll());
        req.getRequestDispatcher(JSP.GROUPS.value()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Group group = new Group();
        group.setName(req.getParameter("name"));
        groupService.create(group);
        resp.sendRedirect(URL.GROUPS.value());
    }
}
