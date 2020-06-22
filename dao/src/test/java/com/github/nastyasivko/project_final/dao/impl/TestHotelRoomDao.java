package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.dao.entity.HotelRoomEntity;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestHotelRoomDao {
    final String name="project_test";
    final HotelRoomDao roomDao = DefaultHotelRoomDao.getInstance();

    @BeforeEach
    void init() {
        Session session = EMUtil.getSession(name);
        session.getTransaction().begin();
        session.persist(new HotelRoomEntity(null, "standart", "2", "101"));
        session.persist(new HotelRoomEntity(null, "suite", "1", "203"));
        session.persist(new HotelRoomEntity(null, "standart", "3", "103"));
        session.persist(new HotelRoomEntity(null, "standart", "2", "302"));
        session.persist(new HotelRoomEntity(null, "honeymoon suite", "2", "110"));
        session.getTransaction().commit();
        session.clear();
    }

//    @Test
//    void addElement() {
//        final boolean result = roomDao.addElement(room);
//        final HotelRoom newRoom = roomDao.getElement(NUMBER_ROOM_FOR_TEST);
//        assertTrue(result);
//        assertEquals(room.getName(), newRoom.getName());
//        assertEquals(room.getListBeds(), newRoom.getListBeds());
//        assertEquals(room.getNumberRoom(), newRoom.getNumberRoom());
//    }
//
//
//    @Test
//    void deleteElement() {
//        final boolean resultAdd = roomDao.addElement(room);
//        final boolean resultDelete = roomDao.deleteElement(room);
//        final HotelRoom newRoom = roomDao.getElement(NUMBER_ROOM_FOR_TEST);
//
//        assertTrue(resultAdd);
//        assertTrue(resultDelete);
//        assertNull(newRoom.getName());
//        assertEquals(NUMBER_ZERO, newRoom.getListBeds());
//        assertEquals(NUMBER_ZERO, newRoom.getNumberRoom());
//    }
//
//    @Test
//    void updateElement() {
//        final boolean resultAdd = roomDao.addElement(room);
//        final HotelRoom updateRoom = new HotelRoom("standart", 2, NUMBER_ROOM_FOR_TEST);
//        final boolean resultUpdate = roomDao.updateElement(updateRoom);
//        final HotelRoom newRoom = roomDao.getElement(NUMBER_ROOM_FOR_TEST);
//
//        assertTrue(resultAdd);
//        assertTrue(resultUpdate);
//        assertEquals(updateRoom.getName(), newRoom.getName());
//        assertEquals(updateRoom.getListBeds(), newRoom.getListBeds());
//        assertEquals(updateRoom.getNumberRoom(), newRoom.getNumberRoom());
//    }

    @Test
    void getNumberRoomExist() {
        UserOrder userOrder = new UserOrder(null,"user", "standart", "2");
        List<String> numberRoom = roomDao.getNumberRoom(name, userOrder.getNameRoom(), userOrder.getBeds());
        System.out.println(numberRoom);
        assertNotNull(numberRoom);
    }

    @Test
    void getNumberRoomNotExist() {
        UserOrder userOrder = new UserOrder(null,"user", "presidential suite", "2");
        List<String> numberRoom = roomDao.getNumberRoom(name, userOrder.getNameRoom(), userOrder.getBeds());
        System.out.println(numberRoom);

        assertEquals(numberRoom.size(),0);
    }


}
