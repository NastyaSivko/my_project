package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Users;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestDefaultLoginUserDao {
    final UserDao userDao = DefaultUserDao.getInstance();
    final LoginUsersDao loginUserDao = DefaultLoginUsersDao.getInstance();
    final String name="project_test";

    @Test
    void findUserExist() {
        Users user = new Users(null, "user", "user", "1234567");
        LoginUsers loginUser = new LoginUsers(null,"loginuser", "user", null);

        userDao.saveLoginUser(name, user, loginUser);
        LoginUsers userForDb = loginUserDao.findLoginUser(name,"loginuser");

        assertNotNull(user);
        assertEquals(userForDb.getLogin(),loginUser.getLogin());
        assertEquals(userForDb.getPassword(),loginUser.getPassword());
    }

    @Test
    void findUserNotExist() {
        Users user = new Users(null, "useruser", "useruser", "1234567");
        LoginUsers loginUser = new LoginUsers(null, "loginuseruser", "user", null);

        userDao.saveLoginUser(name, user, loginUser);
        final LoginUsers userForDb = loginUserDao.findLoginUser(name,"useruser");

        assertNull(userForDb);
    }

}
