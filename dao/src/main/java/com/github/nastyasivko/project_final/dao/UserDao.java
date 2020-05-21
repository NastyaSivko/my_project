package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Users;

public interface UserDao {

    Long saveLoginUser(String nameDb,Users user, LoginUsers loginUser);
}
