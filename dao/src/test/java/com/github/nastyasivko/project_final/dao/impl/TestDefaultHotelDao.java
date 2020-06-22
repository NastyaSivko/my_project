package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.HotelDao;
import com.github.nastyasivko.project_final.dao.entity.HotelRoomEntity;
import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.Room;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDefaultHotelDao {
    final String name="project_test";
    final HotelDao hotelDao = DefaultHotelDao.getInstance();

    @BeforeEach
    public void init(){
        HotelRoomEntity roomStandartOne = new HotelRoomEntity(null, "standart", "2","101");
        HotelRoomEntity roomStandartTwo = new HotelRoomEntity(null, "standart", "3","101");
        HotelRoomEntity roomFamilyRoom = new HotelRoomEntity(null, "family room", "1","101");
        HotelRoomEntity roomHoneyMoon = new HotelRoomEntity(null, "honeymoon", "4","101");
        HotelRoomEntity roomSuite = new HotelRoomEntity(null, "suite", "2","101");
        Session session = EMUtil.getSession(name);
        session.getTransaction().begin();
        session.persist(roomStandartOne);
        session.persist(roomStandartTwo);
        session.persist(roomHoneyMoon);
        session.persist(roomFamilyRoom);
        session.persist(roomSuite);
        session.getTransaction().commit();
    }

    @Test
    void testGetListRooms(){

        List<String> listRooms = hotelDao.getNameRooms(name);

        assertNotNull(listRooms);
        assertEquals(listRooms.size(),4);
    }

    @Test
    void testGetRoomBeds(){
       List<Room> listRoom = hotelDao.getRoomBeds(name);

       assertNotNull(listRoom);
       assertEquals(listRoom.size(),4);
       assertEquals(listRoom.get(0).getListBeds().size(),2);
    }
}
