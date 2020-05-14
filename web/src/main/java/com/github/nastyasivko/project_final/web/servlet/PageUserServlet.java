package com.github.nastyasivko.project_final.web.servlet;

import com.github.nastyasivko.project_final.web.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/pageuser")
public class PageUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Object login = rq.getSession().getAttribute("authUser");
        rq.setAttribute("authUser", login);
        WebUtils.forwardToJsp("pageUser", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        //Object login = rq.getSession().getAttribute("authUser");
        //rq.setAttribute("authUser", login);
    }
}
