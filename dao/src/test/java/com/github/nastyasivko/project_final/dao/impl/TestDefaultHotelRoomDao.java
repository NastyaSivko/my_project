package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.dao.config.DaoConfig;
import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class TestDefaultHotelRoomDao {

    public static final int NUMBER_ZERO = 0;

    @Autowired
    private HotelRoomDao dao;

    private final GregorianCalendar calendarStart = new GregorianCalendar();
    private final GregorianCalendar calendarEnd = new GregorianCalendar();

    @BeforeEach
    void init() {
        dao.saveHotelRoom(new HotelRoom(null, "standart", "2", "101"));
        dao.saveHotelRoom(new HotelRoom(null, "suite", "1", "203"));
        dao.saveHotelRoom(new HotelRoom(null, "standart", "3", "103"));
        dao.saveHotelRoom(new HotelRoom(null, "standart", "2", "302"));
        dao.saveHotelRoom(new HotelRoom(null, "honeymoon suite", "2", "110"));
    }

    @Test
    void testSaveHotelRoom() {
        HotelRoom hotelRoom = new HotelRoom(null, "room", "5", "11111");
        dao.saveHotelRoom(hotelRoom);

        HotelRoom hotelRoomFromEntity = dao.getHotelRoom("11111");

        assertNotNull(hotelRoomFromEntity);
        assertEquals(hotelRoom.getName(), hotelRoomFromEntity.getName());
        assertEquals(hotelRoom.getBed(), hotelRoomFromEntity.getBed());
        assertEquals(hotelRoom.getNumberRoom(), hotelRoomFromEntity.getNumberRoom());
    }


//    @Test
//    void testDeleteHotelRoom() {
//        HotelRoom hotelRoom = new HotelRoom(null, "room", "5", "22222");
//        long id = dao.saveHotelRoom(hotelRoom);
//        final boolean resultDelete = dao.deleteHotelRoom(hotelRoom);
//
//        assertNotNull(id);
//        assertTrue(resultDelete);
//    }

    @Test
    void testUpdateHotelRoom() {
        HotelRoom hotelRoom = new HotelRoom(null, "room", "5", "333333");
        final long id = dao.saveHotelRoom(hotelRoom);
        final boolean resultUpdate = dao.updateHotelRoom(hotelRoom, "new", "1", null);
        final HotelRoom newRoom = dao.getHotelRoom("333333");

        assertNotNull(id);
        assertTrue(resultUpdate);
        assertEquals("new", newRoom.getName());
        assertEquals("1", newRoom.getBed());
    }

    @Test
    void testUpdateHotelRoomNameNull() {
        HotelRoom hotelRoom = new HotelRoom(null, "room", "5", "1");
        final long id = dao.saveHotelRoom(hotelRoom);
        final boolean resultUpdate = dao.updateHotelRoom(hotelRoom, null, "1", null);
        final HotelRoom newRoom = dao.getHotelRoom("1");

        assertNotNull(id);
        assertTrue(resultUpdate);
        assertEquals(hotelRoom.getName(), newRoom.getName());
        assertEquals(hotelRoom.getNumberRoom(), newRoom.getNumberRoom());
    }

    @Test
    void testUpdateHotelRoomAllNull() {
        HotelRoom hotelRoom = new HotelRoom(null, "room", "5", "3");
        final long id = dao.saveHotelRoom(hotelRoom);
        final boolean resultUpdate = dao.updateHotelRoom(hotelRoom, null, null, null);
        final HotelRoom newRoom = dao.getHotelRoom("3");

        assertNotNull(id);
        assertTrue(resultUpdate);
        assertEquals(hotelRoom.getName(), newRoom.getName());
        assertEquals(hotelRoom.getBed(), newRoom.getBed());
        assertEquals(hotelRoom.getNumberRoom(), newRoom.getNumberRoom());
    }

    @Test
    void testGetHotelRoom(){
        HotelRoom hotelRoom = new HotelRoom(null, "room", "5", "4");
        final long id = dao.saveHotelRoom(hotelRoom);

        final HotelRoom hotelRoomFromEntity = dao.getHotelRoom("4");

        assertNotNull(hotelRoomFromEntity);
        assertEquals(hotelRoom.getName(), hotelRoomFromEntity.getName());
        assertEquals(hotelRoom.getBed(), hotelRoomFromEntity.getBed());
        assertEquals(hotelRoom.getNumberRoom(), hotelRoomFromEntity.getNumberRoom());
    }

    @Test
    void getNumberRoomExist() {
        calendarStart.set(2020, 12, 05);
        calendarEnd.set(2020,12,05);
        UserOrder userOrder = new UserOrder(null,"user", "standart", "2", calendarStart.getTime(), calendarEnd.getTime());
        List<String> numberRoom = dao.getNumberRoom(userOrder.getNameRoom(), userOrder.getBeds());

        assertNotNull(numberRoom);
    }

    @Test
    void getNumberRoomNotExist() {
        UserOrder userOrder = new UserOrder(null,"user", "presidential suite", "2", calendarStart.getTime(), calendarEnd.getTime());
        List<String> numberRoom = dao.getNumberRoom(userOrder.getNameRoom(), userOrder.getBeds());
        System.out.println(numberRoom);

        assertEquals(numberRoom.size(),0);
    }


}
