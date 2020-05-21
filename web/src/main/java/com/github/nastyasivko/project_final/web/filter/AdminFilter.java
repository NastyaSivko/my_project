//package com.github.nastyasivko.project_final.web.filter;
//
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.web.WebUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/admin"})
//public class AdminFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, NullPointerException {
//        HttpServletRequest rq = (HttpServletRequest) servletRequest;
//        try {
//            LoginUsers user =(LoginUsers) rq.getSession().getAttribute("authUserLogin");
//            if (user.getLogin().equals("admin")) {
//                filterChain.doFilter(rq, servletResponse);
//            }
//            if(!login.equals("admin")) {
//                rq.setAttribute("error", "Вы не обладаете правами администратора");
//                WebUtils.forwardToJsp("signIn", rq, ((HttpServletResponse) servletResponse));
//                return;
//            }
//        } catch (NullPointerException e) {
//            WebUtils.forwardToJsp("signIn", rq, ((HttpServletResponse) servletResponse));
//            return;
//        }
//    }
//}
