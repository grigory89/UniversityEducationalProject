package com.foxminded.university.servlets;

import com.foxminded.university.services.GroupService;
import com.foxminded.university.services.Impl.GroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/group/delete")
public class GroupDeleteServlet extends HttpServlet {
    private GroupService groupService = new GroupServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("groupId"));
        groupService.delete(id);
        resp.sendRedirect(URL.GROUPS.value());
    }
}
