package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.LoginUsers;

public interface LoginUsersDao {

    LoginUsers findLoginUser(String nameDb, String login);

    LoginUsers getLoginUserForUserId (String nameDb, Long id);

}
