package com.github.nastyasivko.project_final.web.servlet;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.dao.impl.DefaultLoginUsersDao;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.web.WebUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SignInServlet.class);
    private LoginUsersDao authUserDao = DefaultLoginUsersDao.getInstance();
    final String name="project";

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        WebUtils.forwardToJsp("signIn", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.setCharacterEncoding("UTF-8");
        rs.setCharacterEncoding("UTF-8");
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");

        if(login.equals("admin") && password.equals("admin")) {
            rq.getSession().setAttribute("authUser", new LoginUsers(null, login, password, null));
            WebUtils.forwardToJsp("admin", rq, rs);
        }

        LoginUsers user = authUserDao.findLoginUser(name, login);

        if (login.equals("") && password.equals("")){
            WebUtils.forwardToJsp("signIn", rq, rs);
        }

        if (user == null){
            rq.setAttribute("error", "Вы не зарегистрировались");
            WebUtils.forwardToJsp("signIn", rq, rs);
        } else {
            if
            (!user.getPassword().equals(password)){
                rq.setAttribute("error", "Неправильный пароль");
                WebUtils.forwardToJsp("signIn", rq, rs);
            } else {
                log.info("user {}{} logged", user.getLogin());
                rq.getSession().setAttribute("authUser", user);
                WebUtils.forwardToJsp("pageUser", rq, rs);
            }
        }
    }
}
