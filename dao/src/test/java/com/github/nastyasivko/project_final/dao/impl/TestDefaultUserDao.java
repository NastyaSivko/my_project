package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.dao.entity.LoginUsersEntity;
import com.github.nastyasivko.project_final.dao.entity.UserEntity;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Users;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TestDefaultUserDao {
    final UserDao userDao = DefaultUserDao.getInstance();
    final LoginUsersDao loginUserDao = DefaultLoginUsersDao.getInstance();
    final String name="project_test";

    @Test
    void testSaveUser() {
        final Session session = EMUtil.getSession(name);
        Users user = new Users(null, "Nastya", "Test", "1234567");
        LoginUsers loginUser = new LoginUsers(null,"testlog", "testpas", null);

        long id = userDao.saveLoginUser(name, user, loginUser);
        long idLoginUser = loginUserDao.getLoginUserForUserId(name, id).getId();


        UserEntity userEntity = session.get(UserEntity.class, id);
        LoginUsersEntity loginUsersEntity = session.get(LoginUsersEntity.class, idLoginUser);

        assertNotNull(userEntity);
        assertEquals(userEntity.getName(), user.getName());
        assertEquals(userEntity.getSurname(), user.getSurname());
        assertEquals(loginUsersEntity.getLogin(),loginUsersEntity.getLogin());
        assertEquals(loginUsersEntity.getPassword(),loginUsersEntity.getPassword());
        assertEquals(userEntity.getId(),loginUsersEntity.getUserEntity().getId());
    }
}
