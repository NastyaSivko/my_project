package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.HotelRoom;

public interface HotelRoomDao {

    boolean addElement(HotelRoom room);
    boolean deleteElement(HotelRoom room);
    boolean updateElement(HotelRoom room);
    HotelRoom getElement(int numberRoom);
}
