package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.dao.converter.HotelRoomConverter;
import com.github.nastyasivko.project_final.dao.entity.HotelRoomEntity;
import com.github.nastyasivko.project_final.dao.repository.HotelRoomRepository;
import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class DefaultHotelRoomDao implements HotelRoomDao {
    private static final Logger log = LoggerFactory.getLogger(HotelRoomDao.class);

    private final HotelRoomRepository repository;

    public DefaultHotelRoomDao(HotelRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveHotelRoom(HotelRoom room) {
        HotelRoomEntity hotelRoomEntity = HotelRoomConverter.toEntity(room);
        repository.save(hotelRoomEntity);
        return hotelRoomEntity.getId();
    }

    @Override
    public boolean deleteHotelRoom(HotelRoom room) {
        HotelRoomEntity hotelRoomEntity = HotelRoomConverter.toEntity(room);
        String numberRoom = room.getNumberRoom();
        repository.delete(hotelRoomEntity);
        HotelRoom newRoom = DefaultHotelRoomDao.this.getHotelRoom(numberRoom);
        if (newRoom == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateHotelRoom(HotelRoom oldHotelRoom, String name, String bed, String numberRoom) {
        if (name == null) {
            name = oldHotelRoom.getName();
        }
        if (numberRoom == null) {
            numberRoom = oldHotelRoom.getNumberRoom();
        }
        if (bed == null) {
            bed = oldHotelRoom.getBed();
        }
        repository.updateHotelRoom(name, bed, numberRoom);
        return true;
    }

    @Override
    public HotelRoom getHotelRoom(String numberRoom) {
        List<HotelRoomEntity> hotelRoomEntity = repository.findByNumberRoom(numberRoom);
        return HotelRoomConverter.fromEntity(hotelRoomEntity.get(0));
    }

    @Override//дописать отбор ещё и по датам
    public List<String> getNumberRoom(String nameRoom, String bed) {
        List<HotelRoomEntity> hotelRoomEntities = repository.findByNameAndBed(nameRoom, bed);
        List<String> listNumberRoom = new ArrayList<>();
        for(int i = 0; i< hotelRoomEntities.size(); i++){
            listNumberRoom.add(hotelRoomEntities.get(i).getNumberRoom());
        }

        return listNumberRoom;
    }


}
