package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.AdministratorDao;
import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.entity.NewOrdersEntity;
import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserAdministratorDao {
    final String name = "project_test";
    final AdministratorDao userAdministratorDao = UserAdministratorDao.getInstance();

    @BeforeEach
    public void init() {
        Session session = EMUtil.getSession(name);
        session.getTransaction().begin();
        session.persist(new NewOrdersEntity(null, "user", "standart", "2"));
        session.persist(new NewOrdersEntity(null, "usertest", "standart", "6"));
        session.persist(new NewOrdersEntity(null, "testuser", "suite", "1"));
        session.persist(new NewOrdersEntity(null, "user", "honeymoom suite", "3"));
        session.persist(new NewOrdersEntity(null, "usertest", "suite", "2"));
        session.getTransaction().commit();
        session.clear();

    }

    @Test
    void testGetNewOrders() {
        List<UserOrder> orderList = userAdministratorDao.getUsersOrders(name);

        assertNotNull(orderList);
        assertEquals(orderList.size(), 5);
    }

    @Test
    void testDeleteNewOrders() {
        boolean result = userAdministratorDao.deleteNewOrders(name);

        assertTrue(result);
    }

    @Test
    void testGetPage(){
        List<UserOrder> list = userAdministratorDao.getNewOrdersForPage(name, 1);

        assertEquals(list.size(), 3);
    }
}
