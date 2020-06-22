package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.UserOrder;

import java.util.List;

public interface HotelRoomDao {

    boolean addElement(HotelRoom room);
    boolean deleteElement(HotelRoom room);
    boolean updateElement(HotelRoom room);
    List<String> getNumberRoom(String nameDb, String nameRoom, String bed);
}
