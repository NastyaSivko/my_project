package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.AdministratorDao;
import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.entity.CostRoomsEntity;
import com.github.nastyasivko.project_final.dao.entity.NewOrdersEntity;
import com.github.nastyasivko.project_final.model.Costs;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserAdministratorDao {
    final String name = "project_test";
    final AdministratorDao userAdministratorDao = UserAdministratorDao.getInstance();
    final UserOrderDao userOrderDao = DefaultUserOrderDao.getInstance();

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
    }

    @Test
    void testDeleteNewOrders() {
        UserOrder userOrder = new UserOrder(null, "user", "standart", "2");
        boolean result = userAdministratorDao.deleteNewOrders(name, userOrder);

        assertTrue(result);
    }

    @Test
    void testGetPage() {
        List<UserOrder> list = userAdministratorDao.getNewOrdersForPage(name, 1);

        assertEquals(list.size(), 3);
    }

    @Test
    void testApprovedOrder() {
        UserOrder userOrder = new UserOrder(null, "usertest", "standart", "4");
        userOrderDao.saveUserOrder(name, userOrder);
        Costs costs = new Costs(null, 10);
        Session session = EMUtil.getSession(name);
        session.getTransaction().begin();
        session.persist(new CostRoomsEntity(null, costs.getCost()));
        session.getTransaction().commit();

        UserOrder userOrderFromDb = userOrderDao.getUserOrder(name, new UserOrder(null, userOrder.getUserLogin(), userOrder.getNameRoom(), userOrder.getBeds()));

        Long id = userAdministratorDao.saveApprovedOrder(name, userOrderFromDb, 101, costs);

        assertNotNull(id);
    }

    @Test
    void testDeniedOrder() {
        UserOrder userOrder = new UserOrder(null, "usertest", "standartroom", "4");
        userOrderDao.saveUserOrder(name, userOrder);

        UserOrder userOrderFromDb = userOrderDao.getUserOrder(name, new UserOrder(null, userOrder.getUserLogin(), userOrder.getNameRoom(), userOrder.getBeds()));

        Long id = userAdministratorDao.saveDeniedOrder(name, userOrderFromDb);

        assertNotNull(id);
    }
}
