//package com.github.nastyasivko.project_final.web.servlet;
//
//import com.github.nastyasivko.project_final.dao.LoginUserDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultLoginUserDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.service.LoginUser;
//import com.github.nastyasivko.project_final.service.impl.SecurityLoginUser;
//import com.github.nastyasivko.project_final.web.WebUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/signup")
//public class SignUpServlet extends HttpServlet {
//    private static final Logger log = LoggerFactory.getLogger(SignUpServlet.class);
//
//    @Override
//    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        rq.getSession().getAttribute("authUser");
//        WebUtils.forwardToJsp("signup", rq, rs);
//    }
//
//    private LoginUserDao authUserDao = DefaultLoginUserDao.getInstance();
//
//    @Override
//    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        rq.setCharacterEncoding("UTF-8");
//        rs.setCharacterEncoding("UTF-8");
//        String login = rq.getParameter("login");
//        String password = rq.getParameter("password");
//
//        if(login.equals("admin") && password.equals("admin")) {
//            rq.getSession().setAttribute("authUser", login);
//            WebUtils.forwardToJsp("admin", rq, rs);
//        }
//
//        LoginUsers user = authUserDao.findUser(login);
//
//        if (login.equals("") && password.equals("")){
//            WebUtils.forwardToJsp("signup", rq, rs);
//        }
//
//        if (user.getName() == null && user.getPhone() == null && user.getEmail() == null){
//            rq.setAttribute("error", "Вы не зарегистрировались");
//            WebUtils.forwardToJsp("signup", rq, rs);
//        } else {
//            if
//            (!user.getEmail().equals(password)){
//                rq.setAttribute("error", "Неправильный пароль");
//                WebUtils.forwardToJsp("signup", rq, rs);
//            } else {
//                log.info("user {} logged", user.getPhone());
//                rq.setAttribute("authUser", user);
//                WebUtils.forwardToJsp("pageUser", rq, rs);
//            }
//        }
//    }
//}
