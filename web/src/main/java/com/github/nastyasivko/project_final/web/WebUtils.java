package com.github.nastyasivko.project_final.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class WebUtils {
    private WebUtils() {
    }

    public static void forwardToJsp(String jspName, HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.getRequestDispatcher("/" + jspName + ".jsp").forward(rq, rs);
    }

}
