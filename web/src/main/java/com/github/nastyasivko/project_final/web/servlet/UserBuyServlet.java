package com.github.nastyasivko.project_final.web.servlet;

import com.github.nastyasivko.project_final.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userbuy")
public class UserBuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().getAttribute("authUser");
        WebUtils.forwardToJsp("userbuy", req, resp);
    }
}
