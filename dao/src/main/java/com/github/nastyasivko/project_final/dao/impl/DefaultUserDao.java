package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.dao.converter.LoginUserConverter;
import com.github.nastyasivko.project_final.dao.converter.UserConverter;
import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.*;
import com.github.nastyasivko.project_final.model.AnswerUserOrder;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.UserOrder;
import com.github.nastyasivko.project_final.model.Users;
import org.hibernate.Session;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AnswerUserOrder> getUserOrders(String nameDb, String login) {
        final Session session = EMUtil.getSession(nameDb);
        List<UserOrderEntity> userOrderEntity = session.createQuery("from UserOrderEntity o where o.userlogin = :login")
                .setParameter("login", "usertestorder")
                .getResultList();
        List<AnswerUserOrder> userOrders = new ArrayList<>();
        for (UserOrderEntity userOrder : userOrderEntity) {
            Long id = userOrder.getId();
            List<ApprovedOrdersEntity> userApprovedOrderEntity = session.createQuery("from ApprovedOrdersEntity a where a.idUserOrder = :idUserOrder")
                    .setParameter("idUserOrder", id)
                    .getResultList();
            List<DeniedOrdersEntity> userDeniedOrderEntity = session.createQuery("from DeniedOrdersEntity d where d.idUserOrder = :idUserOrder")
                    .setParameter("idUserOrder", id)
                    .getResultList();
            if (userApprovedOrderEntity.size() != 0) {
                userOrders.add(new AnswerUserOrder(userOrder.getUserlogin(), userOrder.getNameRoom(), userOrder.getNumberOfBeds(), userApprovedOrderEntity.get(0).getAnswer(), userApprovedOrderEntity.get(0).getNumberRoom(), userApprovedOrderEntity.get(0).getCostRoomsEntity().getCost()));
            }
            if(userDeniedOrderEntity.size() != 0){
                userOrders.add(new AnswerUserOrder(userOrder.getUserlogin(), userOrder.getNameRoom(), userOrder.getNumberOfBeds(), userDeniedOrderEntity.get(0).getAnswer()));
            }
        }
        return userOrders;
    }
}
