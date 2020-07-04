package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.NewOrderDao;
import com.github.nastyasivko.project_final.dao.config.DaoConfig;
import com.github.nastyasivko.project_final.dao.entity.NewOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class TestDefaultNewOrderDao {
    @Autowired
    private NewOrderDao newOrderDao;

    private final GregorianCalendar calendarStart = new GregorianCalendar();
    private final GregorianCalendar calendarEnd = new GregorianCalendar();

    @Test
    void testSaveNewOrder() {
        calendarStart.set(2020, 12 - 1, 05);
        calendarEnd.set(2020,12 - 1,07);
        UserOrder userOrder = new UserOrder(null, "user", "standart", "4", calendarStart.getTime(), calendarEnd.getTime());
        Long id = newOrderDao.saveNewOrder(userOrder);

        UserOrder newOrderFromEntity = newOrderDao.get(1L);

        assertNotNull(newOrderFromEntity);
        assertEquals(newOrderFromEntity.getUserLogin(), userOrder.getUserLogin());
        assertEquals(newOrderFromEntity.getNameRoom(), userOrder.getNameRoom());
        assertEquals(newOrderFromEntity.getBeds(),userOrder.getBeds());
        assertEquals(newOrderFromEntity.getDateStart(),userOrder.getDateStart());
        assertEquals(newOrderFromEntity.getDateEnd(),userOrder.getDateEnd());
    }
}
