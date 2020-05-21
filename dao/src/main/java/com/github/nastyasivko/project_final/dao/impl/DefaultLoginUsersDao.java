package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.dao.converter.LoginUserConverter;
import com.github.nastyasivko.project_final.dao.entity.LoginUsersEntity;
import com.github.nastyasivko.project_final.model.LoginUsers;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

public class DefaultLoginUsersDao implements LoginUsersDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultLoginUsersDao.class);

    private static class SingletonHolder {
        static final LoginUsersDao HOLDER_INSTANCE = new DefaultLoginUsersDao();
    }

    public static LoginUsersDao getInstance() {
        return DefaultLoginUsersDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public LoginUsers findLoginUser(String nameDb, String login) {
        final Session session = EMUtil.getSession(nameDb);
        LoginUsersEntity loginUser;
        try {
            loginUser = (LoginUsersEntity) session.createQuery("from LoginUsersEntity lu where lu.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by login{}", login);
            loginUser = null;
        }
        return LoginUserConverter.fromEntity(loginUser);
    }

    @Override
    public LoginUsers getLoginUserForUserId (String nameDb, Long id){
        final Session session = EMUtil.getSession(nameDb);
        LoginUsersEntity loginUser;
        try {
            loginUser = (LoginUsersEntity) session.createQuery("from LoginUsersEntity lu where lu.userId = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("user not found by userId{}", id);
            loginUser = null;
        }
        return LoginUserConverter.fromEntity(loginUser);
    }

}
