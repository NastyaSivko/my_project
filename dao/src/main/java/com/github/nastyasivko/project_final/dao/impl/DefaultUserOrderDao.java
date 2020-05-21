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
        Orders order = new Orders(null, null);

        order.setUserOrderEntity(userOrderEntity);

        session.beginTransaction();
        session.persist(userOrderEntity);
        session.getTransaction().commit();

        return userOrderEntity.getId();
    }
}
