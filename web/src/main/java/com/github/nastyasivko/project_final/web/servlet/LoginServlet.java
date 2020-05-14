//package com.github.nastyasivko.project_final.web.servlet;
//
//import com.github.nastyasivko.project_final.dao.UserDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultUserDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.model.Users;
//import com.github.nastyasivko.project_final.service.LoginUser;
//import com.github.nastyasivko.project_final.service.impl.SecurityLoginUser;
//import com.github.nastyasivko.project_final.web.WebUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
//    private UserDao userDao = DefaultUserDao.getInstance();
//    private LoginUser securityLoginUser = SecurityLoginUser.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        WebUtils.forwardToJsp("login", request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        rq.setCharacterEncoding("UTF-8");
//        ServletContext ctx = getServletContext();
//        String name = rq.getParameter("name");
//        String surname = rq.getParameter("surname");
//        String login = rq.getParameter("login");
//        String password = rq.getParameter("password");
//
//        if (login.equals("admin") || login.equals("Admin") || login.equals("ADMIN")) {
//            rq.setAttribute("error", "This login is not write");
//            WebUtils.forwardToJsp("login", rq, rs);
//            return;
//        }
//        Users newUser = new Users(null, name, surname, login, password);
//
//        boolean result = securityLoginUser.dublicateLogin(login);
//
//        if (name.equals("") && surname.equals("") && login.equals("") && password.equals("")){
//            WebUtils.forwardToJsp("login", rq, rs);
//            return;
//        }
//
//        if (name.equals("") || surname.equals("") || login.equals("") || password.equals("")){
//            rq.setAttribute("error", "Please, write down all the forms");
//            WebUtils.forwardToJsp("login", rq, rs);
//            return;
//        }
//
//        if (!result) {
//            rq.setAttribute("error", "This login is already exists");
//            WebUtils.forwardToJsp("login", rq, rs);
//            return;
//        }
//
//        Long id = userDao.save(newUser);
//
//        log.info("user {} save", newUser.getPhone());
//        ctx.setAttribute("user", newUser);
//
//        WebUtils.forwardToJsp("signup", rq, rs);}
//}
