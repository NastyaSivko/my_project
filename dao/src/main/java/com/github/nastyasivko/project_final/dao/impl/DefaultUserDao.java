package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.UserDao;
import com.github.nastyasivko.project_final.dao.converter.LoginUserConverter;
import com.github.nastyasivko.project_final.dao.converter.UserConverter;
import com.github.nastyasivko.project_final.dao.entity.*;
import com.github.nastyasivko.project_final.dao.repository.UserRepository;
import com.github.nastyasivko.project_final.model.AnswerUserOrder;
import com.github.nastyasivko.project_final.model.LoginUser;
import com.github.nastyasivko.project_final.model.User;

import java.util.List;

public class DefaultUserDao implements UserDao {

    private final UserRepository repository;

    public DefaultUserDao(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveLoginUser(User user, LoginUser loginUser) {
        UserEntity userEntity = UserConverter.toEntity(user);
        LoginUserEntity loginUserEntity = LoginUserConverter.toEntity(loginUser);

        loginUserEntity.setUserEntity(userEntity);
        userEntity.setLoginUserEntity(loginUserEntity);
        repository.save(userEntity);
        return userEntity.getId();
    }

    @Override
    public User get(Long id) {
        final UserEntity userEntity = repository.getOne(id);
        return UserConverter.fromEntity(userEntity);
    }

    @Override
    public List<AnswerUserOrder> getUserOrders(String login) {
//        List<UserOrderEntity> userOrderEntity = session.createQuery("from UserOrderEntity o where o.userlogin = :login")
//                .setParameter("login", "usertestorder")
//                .getResultList();
//        List<AnswerUserOrder> userOrders = new ArrayList<>();
//        for (UserOrderEntity userOrder : userOrderEntity) {
//            Long id = userOrder.getId();
//            List<ApprovedOrderEntity> userApprovedOrderEntity = session.createQuery("from ApprovedOrderEntity a where a.idUserOrder = :idUserOrder")
//                    .setParameter("idUserOrder", id)
//                    .getResultList();
//            List<DeniedOrderEntity> userDeniedOrderEntity = session.createQuery("from DeniedOrderEntity d where d.idUserOrder = :idUserOrder")
//                    .setParameter("idUserOrder", id)
//                    .getResultList();
//            if (userApprovedOrderEntity.size() != 0) {
//                userOrders.add(new AnswerUserOrder(userOrder.getUserlogin(), userOrder.getNameRoom(), userOrder.getNumberOfBeds(), userApprovedOrderEntity.get(0).getAnswer(), userApprovedOrderEntity.get(0).getNumberRoom(), userApprovedOrderEntity.get(0).getCostRoomEntity().getCost()));
//            }
//            if(userDeniedOrderEntity.size() != 0){
//                userOrders.add(new AnswerUserOrder(userOrder.getUserlogin(), userOrder.getNameRoom(), userOrder.getNumberOfBeds(), userDeniedOrderEntity.get(0).getAnswer()));
//            }
//        }
//        return userOrders;
        return null;
    }
}
