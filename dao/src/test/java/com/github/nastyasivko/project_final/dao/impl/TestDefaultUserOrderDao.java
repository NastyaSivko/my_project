package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDefaultUserOrderDao {
    final UserOrderDao userOrderDao = DefaultUserOrderDao.getInstance();
    final String name="project_test";

    @Test
    void testSaveUserOrder() {
        final Session session = EMUtil.getSession(name);
        UserOrder userOrder = new UserOrder(null, "user", "standart", "4");
        long id = userOrderDao.saveUserOrder(name, userOrder);

        UserOrderEntity userOrderEntity = session.get(UserOrderEntity.class, id);

        assertNotNull(userOrderEntity);
        assertEquals(userOrderEntity.getUserlogin(), userOrder.getUserLogin());
        assertEquals(userOrderEntity.getNameRoom(), userOrder.getNameRoom());
        assertEquals(userOrderEntity.getNumberOfBeds(),userOrder.getBeds());

        session.getTransaction().begin();
        session.delete(userOrderEntity);
        session.getTransaction().commit();
    }

    @Test
    void testGetUserOrder(){
        final Session session = EMUtil.getSession(name);
        UserOrder userOrder = new UserOrder(null, "useruser", "standart", "3");
        long id = userOrderDao.saveUserOrder(name, userOrder);

        UserOrder userOrderNew = userOrderDao.getUserOrder(name, userOrder);

        assertEquals(userOrderNew.getId(), id);
        assertEquals(userOrderNew.getUserLogin(), userOrder.getUserLogin());
        assertEquals(userOrderNew.getNameRoom(), userOrder.getNameRoom());
        assertEquals(userOrderNew.getBeds(), userOrder.getBeds());

        UserOrderEntity userOrderEntity = session.get(UserOrderEntity.class, id);
        session.getTransaction().begin();
        session.delete(userOrderEntity);
        session.getTransaction().commit();
    }
}
