package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.NewOrdersDao;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.entity.NewOrdersEntity;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDefaultNewOrdersDao {
    final NewOrdersDao userOrderDao = DefaultNewOrderDao.getInstance();
    final String name="project_test";

    @Test
    void testSaveNewOrder() {
        final Session session = EMUtil.getSession(name);
        UserOrder userOrder = new UserOrder(null, "user", "standart", "4");
        userOrderDao.saveNewOrder(name, userOrder);

        NewOrdersEntity userOrderEntity = session.get(NewOrdersEntity.class, 1L);

        assertNotNull(userOrderEntity);
        assertEquals(userOrderEntity.getUserlogin(), userOrder.getUserLogin());
        assertEquals(userOrderEntity.getNameRoom(), userOrder.getNameRoom());
        assertEquals(userOrderEntity.getNumberOfBeds(),userOrder.getBeds());

        session.getTransaction().begin();
        session.delete(userOrderEntity);
        session.getTransaction().commit();
    }
}
