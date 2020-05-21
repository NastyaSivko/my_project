package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.dao.converter.LoginUserConverter;
import com.github.nastyasivko.project_final.dao.converter.UserConverter;
import com.github.nastyasivko.project_final.dao.entity.LoginUsersEntity;
import com.github.nastyasivko.project_final.dao.entity.UserEntity;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Users;
import org.hibernate.Session;

public class DefaultUserDao implements UserDao {

    private static class SingletonHolder {
        static final UserDao HOLDER_INSTANCE = new DefaultUserDao();
    }

    public static UserDao getInstance() {
        return DefaultUserDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Long saveLoginUser(String nameDb, Users user, LoginUsers loginUser) {
        final Session session = EMUtil.getSession(nameDb);
        UserEntity userEntity = UserConverter.toEntity(user);
        LoginUsersEntity loginUserEntity = LoginUserConverter.toEntity(loginUser);

        loginUserEntity.setUserEntity(userEntity);
        userEntity.setLoginUsersEntity(loginUserEntity);
        session.beginTransaction();
        session.persist(userEntity);
        session.getTransaction().commit();
        return userEntity.getId();
    }
}
