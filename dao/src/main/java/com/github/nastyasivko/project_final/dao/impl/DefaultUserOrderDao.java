package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.converter.UserOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.Orders;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;

public class DefaultUserOrderDao implements UserOrderDao {

    private static class SingletonHolder {
        static final UserOrderDao HOLDER_INSTANCE = new DefaultUserOrderDao();
    }

    public static UserOrderDao getInstance() {
        return DefaultUserOrderDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Long saveUserOrder(String nameDb, UserOrder userOrder) {

        final Session session = EMUtil.getSession(nameDb);
        UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);

        session.beginTransaction();
        session.persist(userOrderEntity);
        session.getTransaction().commit();

        return userOrderEntity.getId();
    }
    
    @Override
    public  UserOrder getUserOrder(String nameDb, UserOrder userOrder){
        final Session session = EMUtil.getSession(nameDb);
        session.getTransaction().begin();
        UserOrderEntity userOrderEntity = (UserOrderEntity) session.createQuery("select n from UserOrderEntity n where n.userlogin = :login and n.nameRoom = :room and n.numberOfBeds = :bed ")
                .setParameter("login", userOrder.getUserLogin())
                .setParameter("room", userOrder.getNameRoom())
                .setParameter("bed", userOrder.getBeds())
                .getSingleResult();
        session.getTransaction().commit();
        return UserOrderConverter.fromEntity(userOrderEntity);
    }
}
