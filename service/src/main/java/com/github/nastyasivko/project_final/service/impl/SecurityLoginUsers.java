package com.github.nastyasivko.project_final.service.impl;

import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.dao.impl.DefaultLoginUsersDao;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.service.SecurityLoginUser;

public class SecurityLoginUsers implements SecurityLoginUser {

    private static class SingletonHolder {
        static final SecurityLoginUser HOLDER_INSTANCE = new SecurityLoginUsers();
    }

    public static SecurityLoginUser getInstance() {
        return SecurityLoginUsers.SingletonHolder.HOLDER_INSTANCE;
    }

    private LoginUsersDao loginUserDao = DefaultLoginUsersDao.getInstance();

    @Override
    public boolean dublicateLogin(String name, String login) {
        LoginUsers user = loginUserDao.findLoginUser(name, login);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

}
