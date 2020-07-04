package com.github.nastyasivko.project_final.dao.converter;

import com.github.nastyasivko.project_final.dao.entity.UserOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserOrderComverter {

    private final GregorianCalendar calendarStart = new GregorianCalendar();
    private final GregorianCalendar calendarEnd = new GregorianCalendar();

    @Test
    void fromEntityNull() {
        final UserOrder userOrder = UserOrderConverter.fromEntity(null);
        assertNull(userOrder);
    }

    @Test
    void fromEntityNotNull() {
        final UserOrderEntity userOrderEntity = new UserOrderEntity();
        calendarStart.set(2020, 12, 05);
        calendarEnd.set(2020,12,05);
        userOrderEntity.setId(1L);
        userOrderEntity.setUserlogin("user");
        userOrderEntity.setNameRoom("standart");
        userOrderEntity.setNumberOfBeds("1");
        userOrderEntity.setDateStart(calendarStart.getTime());
        userOrderEntity.setDateStart(calendarEnd.getTime());

        final UserOrder userOrder = UserOrderConverter.fromEntity(userOrderEntity);

        assertNotNull(userOrder);
        assertEquals(userOrder.getId(), userOrderEntity.getId());
        assertEquals(userOrder.getUserLogin(), userOrderEntity.getUserlogin());
        assertEquals(userOrder.getNameRoom(), userOrderEntity.getNameRoom());
        assertEquals(userOrder.getBeds(), userOrderEntity.getNumberOfBeds());
        assertEquals(userOrder.getDateStart(), userOrderEntity.getDateStart());
        assertEquals(userOrder.getDateEnd(), userOrderEntity.getDateEnd());
    }

    @Test
    void toEntityNull() {
        final UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(null);
        assertNull(userOrderEntity);
    }

    @Test
    void toEntityNotNull() {
        calendarStart.set(2020, 12, 05);
        calendarEnd.set(2020,12,05);
        final UserOrder userOrder = new UserOrder(1L, "user", "standart", "3", calendarStart.getTime(), calendarEnd.getTime());

        final UserOrderEntity userOrderEntity = UserOrderConverter.toEntity(userOrder);

        assertNotNull(userOrderEntity);
        assertEquals(userOrder.getId(), userOrderEntity.getId());
        assertEquals(userOrder.getUserLogin(), userOrderEntity.getUserlogin());
        assertEquals(userOrder.getNameRoom(), userOrderEntity.getNameRoom());
        assertEquals(userOrder.getBeds(), userOrderEntity.getNumberOfBeds());
        assertEquals(userOrder.getDateStart(), userOrderEntity.getDateStart());
        assertEquals(userOrder.getDateEnd(), userOrderEntity.getDateEnd());
    }
}
