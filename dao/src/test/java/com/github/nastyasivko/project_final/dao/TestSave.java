package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.dao.entity.UserEntity;
import com.github.nastyasivko.project_final.dao.impl.DefaultUserDao;
import com.github.nastyasivko.project_final.model.Users;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TestSave {
    final UserDao userDao = DefaultUserDao.getInstance();

    @Test
    void testSaveLoginUser() {
        Session session = EMUtilForTest.getSession();
        Users user = new Users(null, "Nastya", "Test", "1234567");

        long id = userDao.saveUser(session, user);

        UserEntity userEntity = EMUtilForTest.getSession().get(UserEntity.class, id);

        assertNotNull(userEntity);
        assertEquals(userEntity.getName(), user.getName());
        assertEquals(userEntity.getSurname(), user.getSurname());
    }
}
