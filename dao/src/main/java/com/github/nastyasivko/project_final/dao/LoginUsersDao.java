package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.LoginUsers;

public interface LoginUsersDao {

    LoginUsers findUser(String login);

}
