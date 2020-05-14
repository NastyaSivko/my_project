package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.model.HotelRoom;

public class HotelDao implements HotelRoomDao {

    private static class SingletonHolder {
        static final HotelRoomDao HOLDER_INSTANCE = new HotelDao();
    }

    public static HotelRoomDao getInstance() {
        return HotelDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public boolean addElement(HotelRoom room) {
        return false;
    }

    @Override
    public boolean deleteElement(HotelRoom room) {
        return false;
    }

    @Override
    public boolean updateElement(HotelRoom room) {
        return false;
    }

    @Override
    public HotelRoom getElement(int numberRoom) {
        return null;
    }
}
