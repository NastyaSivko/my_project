package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.converter.LoginUserConverter;
import com.github.nastyasivko.project_final.dao.converter.UserConverter;
import com.github.nastyasivko.project_final.dao.entity.LoginUsersEntity;
import com.github.nastyasivko.project_final.dao.entity.UserEntity;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Users;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRelationships {
    final String name="project_test";

    @Test
    void testOneToOne() {
        final Session session = EMUtil.getSession(name);

        Users user = new Users(null, "user", "useruser", "123456789");
        LoginUsers loginUser = new LoginUsers(null, "userlogin", "passuser", null);

        UserEntity userEntity = UserConverter.toEntity(user);
        LoginUsersEntity loginUsersEntity = LoginUserConverter.toEntity(loginUser);

        loginUsersEntity.setUserEntity(userEntity);
        userEntity.setLoginUsersEntity(loginUsersEntity);

        session.getTransaction().begin();
        session.persist(userEntity);
        Long id = userEntity.getId();
        Long idLoginUser = loginUsersEntity.getId();
        session.getTransaction().commit();

        session.getTransaction().begin();

        UserEntity userFromDb = session.find(UserEntity.class, id);
        LoginUsersEntity loginUserFromDb = session.find(LoginUsersEntity.class, idLoginUser);

        session.clear();

        assertEquals(userFromDb.getId(), loginUserFromDb.getUserEntity().getId());

    }
}
