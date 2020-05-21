package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.Room;

import java.util.List;

public interface HotelDao {

    List<String> getNameRooms(String nameDb);

    List<Room> getRoomBeds(String nameDb);
}
