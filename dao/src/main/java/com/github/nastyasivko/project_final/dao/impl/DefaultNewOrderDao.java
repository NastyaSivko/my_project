package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.NewOrdersDao;
import com.github.nastyasivko.project_final.dao.converter.NewOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.NewOrdersEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;

public class DefaultNewOrderDao implements NewOrdersDao {
    private static class SingletonHolder {
        static final NewOrdersDao HOLDER_INSTANCE = new DefaultNewOrderDao();
    }

    public static NewOrdersDao getInstance() {
        return DefaultNewOrderDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Long saveNewOrder(String nameDb, UserOrder userOrder) {

        final Session session = EMUtil.getSession(nameDb);
        NewOrdersEntity newOrdersEntity = NewOrderConverter.toEntity(userOrder);

        session.beginTransaction();
        session.persist(newOrdersEntity);
        session.getTransaction().commit();

        return newOrdersEntity.getId();
    }
}
