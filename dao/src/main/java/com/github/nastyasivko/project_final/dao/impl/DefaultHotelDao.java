package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.HotelDao;
import com.github.nastyasivko.project_final.model.Room;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DefaultHotelDao implements HotelDao {

    private static class SingletonHolder {
        static final HotelDao HOLDER_INSTANCE = new DefaultHotelDao();
    }

    public static HotelDao getInstance() {
        return DefaultHotelDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<String> getNameRooms(String nameDb) {
        Session session = EMUtil.getSession(nameDb);
        List<String> listRooms = session.createQuery("select r.name from HotelRoomEntity r group by r.name")
                .getResultList();
        return listRooms;
    }

    @Override
    public List<Room> getRoomBeds(String nameDb) {
        Session session = EMUtil.getSession(nameDb);
        List<String> listRooms = DefaultHotelDao.getInstance().getNameRooms(nameDb);
        List<Room> listRoom = new ArrayList<>();
        for (int i = 0; i < listRooms.size(); i++) {
            List<Integer> listBeds = session.createQuery("select r.beds from HotelRoomEntity r where r.name = :name group by r.beds order by r.beds asc")
                    .setParameter("name", listRooms.get(i))
                    .getResultList();
            Room room = new Room(listRooms.get(i), listBeds);
            listRoom.add(room);
        }
        return listRoom;
    }
}
