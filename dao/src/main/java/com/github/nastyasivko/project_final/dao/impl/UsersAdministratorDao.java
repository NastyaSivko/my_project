package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.model.LoginUsers;

public class UsersAdministratorDao implements LoginUsersDao {

    private static class SingletonHolder {
        static final LoginUsersDao HOLDER_INSTANCE = new UsersAdministratorDao();
    }

    public static LoginUsersDao getInstance() {
        return UsersAdministratorDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public LoginUsers findUser(String login) {
        return null;
    }
}
