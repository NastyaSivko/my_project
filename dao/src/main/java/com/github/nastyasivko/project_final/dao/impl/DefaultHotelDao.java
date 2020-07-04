package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.HotelDao;
import com.github.nastyasivko.project_final.dao.repository.HotelRoomRepository;
import com.github.nastyasivko.project_final.model.Room;

import java.util.ArrayList;
import java.util.List;

public class DefaultHotelDao implements HotelDao {

    private final HotelRoomRepository repository;

    public DefaultHotelDao(HotelRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> getNameRooms() {
        List<String> listRooms = repository.getGroupBy();
        return listRooms;
    }

    @Override
    public List<Room> getRoomBeds() {
        List<String> listRooms = DefaultHotelDao.this.getNameRooms();
        List<Room> listRoom = new ArrayList<>();
        for (int i = 0; i < listRooms.size(); i++) {
            List<Integer> listBeds = repository.getRoomBed(listRooms.get(i));
            Room room = new Room(listRooms.get(i), listBeds);
            listRoom.add(room);
        }
        return listRoom;
    }
}
