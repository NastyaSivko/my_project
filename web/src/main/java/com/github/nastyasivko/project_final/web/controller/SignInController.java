package com.github.nastyasivko.project_final.web.controller;


import com.github.nastyasivko.project_final.dao.LoginUserDao;
import com.github.nastyasivko.project_final.model.LoginUser;
import com.github.nastyasivko.project_final.service.SecurityLoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class SignInController {
    private static final Logger log = LoggerFactory.getLogger(SignInController.class);

    private final SecurityLoginUser securityLoginUser;

    private final LoginUserDao loginUserDao;

    public SignInController(SecurityLoginUser securityLoginUser, LoginUserDao loginUserDao) {
        this.securityLoginUser = securityLoginUser;
        this.loginUserDao = loginUserDao;
    }

    @GetMapping(value = "/signin")
    public String login() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || "anonymousUser".equals(authentication.getPrincipal())) {
            return "signin";
        }
        return "pageUser";
    }

    @PostMapping(value = "/signin")
    public String login(HttpServletRequest rq) {
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");
        if(login.equals("admin") && password.equals("admin")) {
            rq.getSession().setAttribute("authUser", new LoginUser(null, login, password, null));
            return "admin";
        }

        LoginUser user = loginUserDao.findLoginUser(login);

        if (login.equals("") && password.equals("")){
            return "signIn";
        }

        if (user == null){
            rq.setAttribute("error", "Вы не зарегистрировались");
            return "signIn";
        } else {
            if
            (!user.getPassword().equals(password)){
                rq.setAttribute("error", "Неправильный пароль");
                return "signIn";
            } else {
                log.info("user {}{} logged", user.getLogin());
                rq.getSession().setAttribute("authUser", user);
                Authentication auth = new UsernamePasswordAuthenticationToken(user, null);
                SecurityContextHolder.getContext().setAuthentication(auth);

                return "pageUser";
            }
        }
    }
}
