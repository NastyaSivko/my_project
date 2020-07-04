//package com.github.nastyasivko.project_final.web.servlet;
//
//import com.github.nastyasivko.project_final.web.WebUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/logout")
//public class LogoutServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        rq.getSession().removeAttribute("authUser");
//        rq.getSession().invalidate();
//        WebUtils.forwardToJsp("index", rq, rs);
//    }
//}
