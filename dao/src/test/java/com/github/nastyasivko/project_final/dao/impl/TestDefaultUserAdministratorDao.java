package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.CostDao;
import com.github.nastyasivko.project_final.dao.NewOrderDao;
import com.github.nastyasivko.project_final.dao.UserAdministratorDao;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.config.DaoConfig;
import com.github.nastyasivko.project_final.dao.converter.NewOrderConverter;
import com.github.nastyasivko.project_final.dao.entity.CostRoomEntity;
import com.github.nastyasivko.project_final.dao.entity.NewOrderEntity;
import com.github.nastyasivko.project_final.model.Cost;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class TestDefaultUserAdministratorDao {
    public static final int PAGE = 1;
    @Autowired
    private NewOrderDao newOrderDao;

    @Autowired
    private UserOrderDao userOrderDao;

    @Autowired
    private CostDao costDao;
    @Autowired
    private UserAdministratorDao adminDao;

    private final GregorianCalendar calendarStart = new GregorianCalendar();
    private final GregorianCalendar calendarEnd = new GregorianCalendar();


    @BeforeEach
    public void init() {
        calendarStart.set(2020, 12, 05);
        calendarEnd.set(2020, 12, 05);
        newOrderDao.saveNewOrder(new UserOrder(null, "user", "standart", "2", calendarStart.getTime(), calendarEnd.getTime()));
        newOrderDao.saveNewOrder(new UserOrder(null, "usertest", "standart", "6", calendarStart.getTime(), calendarEnd.getTime()));
        newOrderDao.saveNewOrder(new UserOrder(null, "testuser", "suite", "1", calendarStart.getTime(), calendarEnd.getTime()));
        newOrderDao.saveNewOrder(new UserOrder(null, "user", "honeymoom suite", "3", calendarStart.getTime(), calendarEnd.getTime()));
        newOrderDao.saveNewOrder(new UserOrder(null, "usertest", "suite", "2", calendarStart.getTime(), calendarEnd.getTime()));
    }

    @Test
    void testGetNewOrders() {
        List<UserOrder> orderList = adminDao.getUsersOrders();

        assertNotNull(orderList);
    }

    @Test
    void testDeleteNewOrders() {
        UserOrder userOrder = new UserOrder(null, "user", "standart", "2", calendarStart.getTime(), calendarEnd.getTime());
        boolean result = adminDao.deleteNewOrders(userOrder);

        assertTrue(result);
    }

    @Test
    void testGetPage() {
        List<UserOrder> list = adminDao.getNewOrdersForPage(PAGE);

        assertEquals(list.size(), 3);
    }

    @Test
    void testApprovedOrder() {
        UserOrder userOrder = new UserOrder(null, "usertest", "standart", "4", calendarStart.getTime(), calendarEnd.getTime());
        userOrderDao.saveUserOrder(userOrder);
        Cost cost = new Cost(null, 1000);

        costDao.saveCost(new Cost(null, cost.getCost()));

        UserOrder userOrderFromDb = userOrderDao.getUserOrder(new UserOrder(null, userOrder.getUserLogin(), userOrder.getNameRoom(), userOrder.getBeds(), userOrder.getDateStart(), userOrder.getDateEnd()));

        Long id = adminDao.saveApprovedOrder(userOrderFromDb, 101, cost);

        assertNotNull(id);
    }

    @Test
    void testDeniedOrder() {
        UserOrder userOrder = new UserOrder(null, "usertest", "standartroom", "4", calendarStart.getTime(), calendarEnd.getTime());
        userOrderDao.saveUserOrder(userOrder);

        UserOrder userOrderFromDb = userOrderDao.getUserOrder(new UserOrder(null, userOrder.getUserLogin(), userOrder.getNameRoom(), userOrder.getBeds(), userOrder.getDateStart(), userOrder.getDateEnd()));

        Long id = adminDao.saveDeniedOrder(userOrderFromDb);

        assertNotNull(id);
    }
}
