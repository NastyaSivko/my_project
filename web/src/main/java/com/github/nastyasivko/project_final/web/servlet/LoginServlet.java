package com.github.nastyasivko.project_final.web.servlet;

import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.dao.impl.DefaultUserDao;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Users;
import com.github.nastyasivko.project_final.service.SecurityLoginUser;
import com.github.nastyasivko.project_final.service.impl.SecurityLoginUsers;
import com.github.nastyasivko.project_final.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    private UserDao userDao = DefaultUserDao.getInstance();
    private SecurityLoginUser securitySecurityLoginUser = SecurityLoginUsers.getInstance();
    final String name="project";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.forwardToJsp("login", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.setCharacterEncoding("UTF-8");
        ServletContext ctx = getServletContext();
        String nameUser = rq.getParameter("name");
        String surname = rq.getParameter("surname");
        String phone =  rq.getParameter("phone");
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");

        if (login.equals("admin") || login.equals("Admin") || login.equals("ADMIN")) {
            rq.setAttribute("error", "This login is not write");
            WebUtils.forwardToJsp("login", rq, rs);
            return;
        }
        Users newUser = new Users(null, nameUser, surname, phone);
        LoginUsers newLoginUser = new LoginUsers(null, login, password, null);

        boolean result = securitySecurityLoginUser.dublicateLogin(name, login);

        if (name.equals("") && surname.equals("") && login.equals("") && password.equals("")) {
            WebUtils.forwardToJsp("login", rq, rs);
            return;
        }

        if (name.equals("") || surname.equals("") || login.equals("") || password.equals("")) {
            rq.setAttribute("error", "Please, write down all the forms");
            WebUtils.forwardToJsp("login", rq, rs);
            return;
        }

        if (!result) {
            rq.setAttribute("error", "This login is already exists");
            WebUtils.forwardToJsp("login", rq, rs);
            return;
        }

        userDao.saveLoginUser(name, newUser, newLoginUser);

        log.info("user {}{} save", newUser.getName(), newLoginUser.getLogin());
        ctx.setAttribute("user", newUser);

        WebUtils.forwardToJsp("signIn", rq, rs);
    }
}
