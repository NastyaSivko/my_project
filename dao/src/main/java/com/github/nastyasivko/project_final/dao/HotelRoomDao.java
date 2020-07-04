package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.UserOrder;

import java.util.List;

public interface HotelRoomDao {

    Long saveHotelRoom(HotelRoom room);
    boolean deleteHotelRoom(HotelRoom room);
    boolean updateHotelRoom(HotelRoom oldHotelRoom, String name, String bed, String numberRoom);
    HotelRoom getHotelRoom(String numberRoom);
    List<String> getNumberRoom(String nameRoom, String bed);
}
