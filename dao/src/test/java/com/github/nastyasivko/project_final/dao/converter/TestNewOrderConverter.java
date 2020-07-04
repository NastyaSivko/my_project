package com.github.nastyasivko.project_final.dao.converter;

import com.github.nastyasivko.project_final.dao.entity.NewOrderEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNewOrderConverter {

    private final GregorianCalendar calendarStart = new GregorianCalendar();
    private final GregorianCalendar calendarEnd = new GregorianCalendar();

    @Test
    void fromEntityNull() {
        final UserOrder userOrder = NewOrderConverter.fromEntity(null);
        assertNull(userOrder);
    }

    @Test
    void fromEntityNotNull() {
        final NewOrderEntity newOrderEntity = new NewOrderEntity();
        calendarStart.set(2020, 12, 05);
        calendarEnd.set(2020,12,05);
        newOrderEntity.setId(1L);
        newOrderEntity.setUserlogin("user");
        newOrderEntity.setNameRoom("standart");
        newOrderEntity.setNumberOfBeds("1");
        newOrderEntity.setDateStart(calendarStart.getTime());
        newOrderEntity.setDateStart(calendarEnd.getTime());

        final UserOrder userOrder = NewOrderConverter.fromEntity(newOrderEntity);

        assertNotNull(userOrder);
        assertEquals(userOrder.getId(), newOrderEntity.getId());
        assertEquals(userOrder.getUserLogin(), newOrderEntity.getUserlogin());
        assertEquals(userOrder.getNameRoom(), newOrderEntity.getNameRoom());
        assertEquals(userOrder.getBeds(), newOrderEntity.getNumberOfBeds());
        assertEquals(userOrder.getDateStart(), newOrderEntity.getDateStart());
        assertEquals(userOrder.getDateEnd(), newOrderEntity.getDateEnd());
    }

    @Test
    void toEntityNull() {
        final NewOrderEntity newOrderEntity = NewOrderConverter.toEntity(null);
        assertNull(newOrderEntity);
    }

    @Test
    void toEntityNotNull() {
        calendarStart.set(2020, 12, 05);
        calendarEnd.set(2020,12,05);
        final UserOrder userOrder = new UserOrder(1L, "user", "standart", "3", calendarStart.getTime(), calendarEnd.getTime());

        final NewOrderEntity newOrderEntity = NewOrderConverter.toEntity(userOrder);

        assertNotNull(newOrderEntity);
        assertEquals(userOrder.getId(), newOrderEntity.getId());
        assertEquals(userOrder.getUserLogin(), newOrderEntity.getUserlogin());
        assertEquals(userOrder.getNameRoom(), newOrderEntity.getNameRoom());
        assertEquals(userOrder.getBeds(), newOrderEntity.getNumberOfBeds());
        assertEquals(userOrder.getDateStart(), newOrderEntity.getDateStart());
        assertEquals(userOrder.getDateEnd(), newOrderEntity.getDateEnd());
    }
}
