package com.github.nastyasivko.project_final.web.filter;

import com.github.nastyasivko.project_final.web.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns={"/pageuser","/userbuy","/admin","/vieworder"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, NullPointerException {
        HttpServletRequest rq = (HttpServletRequest) servletRequest;
        Object user = rq.getSession().getAttribute("authUser");
        if (user == null) {
            WebUtils.forwardToJsp("signIn", rq, ((HttpServletResponse) servletResponse));
            return;
        }
        filterChain.doFilter(rq, servletResponse);
    }
}