package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.dao.converter.UserConverter;
import com.github.nastyasivko.project_final.dao.entity.UserEntity;
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
    public Long saveUser(Session session, Users user) {
        UserEntity userEntity = UserConverter.toEntity(user);
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
        return userEntity.getId();
    }
}
