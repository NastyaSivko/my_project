//package com.github.nastyasivko.project_final.dao;
//
//import com.github.nastyasivko.project_final.dao.impl.HotelRoomDao;
//import com.github.nastyasivko.project_final.model.HotelRoom;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static com.github.nastyasivko.project_final.dao.TestUtils.deleteAllTable;
//import static com.github.nastyasivko.project_final.dao.TestUtils.deleteRoomForNumberRoom;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestHotelRoomDao {
//    public static final int NUMBER_ROOM_FOR_TEST = 105;
//    public static final int NUMBER_ZERO = 0;
//    final HotelRoomsDao roomDao = HotelRoomDao.getInstance();
//    final HotelRoom room = new HotelRoom("suite", 3, 105);
//
//    @BeforeEach
//    void deleteTable() {
//        String table = "database_rooms";
//        deleteAllTable(table);
//    }
//
//    @Test
//    void addElement() {
//        final boolean result = roomDao.addElement(room);
//        final HotelRoom newRoom = roomDao.getElement(NUMBER_ROOM_FOR_TEST);
//        assertTrue(result);
//        assertEquals(room.getName(), newRoom.getName());
//        assertEquals(room.getBeds(), newRoom.getBeds());
//        assertEquals(room.getNumberRoom(), newRoom.getNumberRoom());
//    }
//
//    @AfterEach
//    void deleteRoomAfterAdd() {
//        deleteRoomForNumberRoom(NUMBER_ROOM_FOR_TEST);
//    }
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
//        assertEquals(NUMBER_ZERO, newRoom.getBeds());
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
//        assertEquals(updateRoom.getBeds(), newRoom.getBeds());
//        assertEquals(updateRoom.getNumberRoom(), newRoom.getNumberRoom());
//    }
//
//    @AfterEach
//    void deleteRoomAfterUpdate() {
//        deleteRoomForNumberRoom(NUMBER_ROOM_FOR_TEST);
//    }
//
//    @Test
//    void getElement() {
//        final boolean resultAdd = roomDao.addElement(room);
//        final HotelRoom newRoom = roomDao.getElement(NUMBER_ROOM_FOR_TEST);
//
//        assertTrue(resultAdd);
//        assertEquals(room.getName(), newRoom.getName());
//        assertEquals(room.getBeds(), newRoom.getBeds());
//        assertEquals(room.getNumberRoom(), newRoom.getNumberRoom());
//    }
//
//    @AfterEach
//    void deleteRoomAfterGet() {
//        deleteRoomForNumberRoom(NUMBER_ROOM_FOR_TEST);
//    }
//
//}
