package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.dao.converter.HotelRoomConverter;
import com.github.nastyasivko.project_final.dao.entity.ApprovedOrderEntity;
import com.github.nastyasivko.project_final.dao.entity.HotelRoomEntity;
import com.github.nastyasivko.project_final.dao.repository.ApprovedOrderRepository;
import com.github.nastyasivko.project_final.dao.repository.HotelRoomRepository;
import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DefaultHotelRoomDao implements HotelRoomDao {
    private static final Logger log = LoggerFactory.getLogger(HotelRoomDao.class);

    private final HotelRoomRepository repository;
    private final ApprovedOrderRepository approvedOrderRepository;

    public DefaultHotelRoomDao(HotelRoomRepository repository, ApprovedOrderRepository approvedOrderRepository) {

        this.repository = repository;
        this.approvedOrderRepository = approvedOrderRepository;
    }

    @Override
    public Long saveHotelRoom(HotelRoom room) {
        HotelRoomEntity hotelRoomEntity = HotelRoomConverter.toEntity(room);
        repository.save(hotelRoomEntity);
        return hotelRoomEntity.getId();
    }

    @Override
    public void deleteHotelRoom(HotelRoom room) {
        HotelRoomEntity hotelRoomEntity = HotelRoomConverter.toEntity(room);
        repository.delete(hotelRoomEntity);
    }

    @Override
    public void updateHotelRoom(HotelRoom oldHotelRoom, String name, String bed, String numberRoom) {
        if (name.equals("")) {
            name = oldHotelRoom.getName();
        }
        if (numberRoom.equals("")) {
            numberRoom = oldHotelRoom.getNumberRoom();
        }
        if (bed.equals("")) {
            bed = oldHotelRoom.getBed();
        }
        repository.updateHotelRoom(name, bed, numberRoom, oldHotelRoom.getId());
    }

    @Override
    public HotelRoom getHotelRoom(String numberRoom) {
        List<HotelRoomEntity> hotelRoomEntity = repository.findByNumberRoom(numberRoom);
        return HotelRoomConverter.fromEntity(hotelRoomEntity.get(0));
    }

    @Override
    public List<String> getNumberRoom(String nameRoom, String bed, String dateStart, String dateEnd) {
        List<HotelRoomEntity> hotelRoomEntities = repository.findByNameAndBed(nameRoom, bed);
        List<String> listNumberRoom = new ArrayList<>();
        for (int i = 0; i < hotelRoomEntities.size(); i++) {
            listNumberRoom.add(hotelRoomEntities.get(i).getNumberRoom());
        }
        List<String> listFreeNumberRoom = new ArrayList<>();
        for (int i = 0; i < listNumberRoom.size(); i++) {
            List<ApprovedOrderEntity> approvedOrderEntities = approvedOrderRepository.findByNumberRoom(parseInt(listNumberRoom.get(i)));
            int c = 0;
            for (int j = 0; j < approvedOrderEntities.size(); j++) {
                if (parseInt(listNumberRoom.get(i)) != approvedOrderEntities.get(j).getNumberRoom()) {
                    c++;
                }
            }
            if (c == approvedOrderEntities.size()) {
                listFreeNumberRoom.add(listNumberRoom.get(i));
                continue;
            }
            for (int j = 0; j < approvedOrderEntities.size(); j++) {
                String[] strStart;
                String[] strEnd;
                String delimetr = "-";
                strStart = approvedOrderEntities.get(j).getDateStart().split(delimetr);
                strEnd = approvedOrderEntities.get(j).getDateEnd().split(delimetr);
                List<String> listDate = new ArrayList<>();
                if (strStart[1].equals(strEnd[1])) {
                    for (int k = parseInt(strStart[2]); k <= parseInt(strEnd[2]); k++) {
                        if (k < 10) {
                            listDate.add(strStart[1] + "-0" + k);
                        }
                        if (k >= 10) {
                            listDate.add(strStart[1] + "-" + k);
                        }
                    }
                } else if (strStart[1].equals("12") || strStart[1].equals("01") || strStart[1].equals("03") || strStart[1].equals("05") || strStart[1].equals("07") || strStart[1].equals("08") || strStart[1].equals("10")) {
                    for (int k = parseInt(strStart[2]); k <= 31; k++) {
                        if (k < 10) {
                            listDate.add(strStart[1] + "-0" + k);
                        }
                        if (k >= 10) {
                            listDate.add(strStart[1] + "-" + k);
                        }
                    }
                    for (int k = 1; k <= parseInt(strEnd[2]); k++) {
                        if (k < 10) {
                            listDate.add(strEnd[1] + "-0" + k);
                        }
                        if (k >= 10) {
                            listDate.add(strEnd[1] + "-" + k);
                        }
                    }
                } else if (strStart[1].equals("04") || strStart[1].equals("06") || strStart[1].equals("09") || strStart[1].equals("11")) {
                    for (int k = parseInt(strStart[2]); k <= 30; k++) {
                        if (k < 10) {
                            listDate.add(strStart[1] + "-0" + k);
                        }
                        if (k >= 10) {
                            listDate.add(strStart[1] + "-" + k);
                        }
                    }
                    for (int k = 1; k <= parseInt(strEnd[2]); k++) {
                        if (k < 10) {
                            listDate.add(strEnd[1] + "-0" + k);
                        }
                        if (k >= 10) {
                            listDate.add(strEnd[1] + "-" + k);
                        }
                    }
                } else if (strStart[1].equals("02")) {
                    if (parseInt(strStart[0]) % 4 == 0 && (parseInt(strStart[0]) % 100 != 0 || parseInt(strStart[0]) % 400 == 0)) {
                        for (int k = parseInt(strStart[2]); k <= 29; k++) {
                            if (k < 10) {
                                listDate.add(strStart[1] + "-0" + k);
                            }
                            if (k >= 10) {
                                listDate.add(strStart[1] + "-" + k);
                            }
                        }
                        for (int k = 1; k <= parseInt(strEnd[2]); k++) {
                            if (k < 10) {
                                listDate.add(strEnd[1] + "-0" + k);
                            }
                            if (k >= 10) {
                                listDate.add(strEnd[1] + "-" + k);
                            }
                        }
                    } else {
                        for (int k = parseInt(strStart[2]); k <= 28; k++) {
                            if (k < 10) {
                                listDate.add(strStart[1] + "-0" + k);
                            }
                            if (k >= 10) {
                                listDate.add(strStart[1] + "-" + k);
                            }
                        }
                        for (int k = 1; k <= parseInt(strEnd[2]); k++) {
                            if (k < 10) {
                                listDate.add(strEnd[1] + "-0" + k);
                            }
                            if (k >= 10) {
                                listDate.add(strEnd[1] + "-" + k);
                            }
                        }
                    }
                }
                String[] strUserDateStart;
                String[] strUserDateEnd;
                strUserDateStart = dateStart.split(delimetr);
                strUserDateEnd = dateEnd.split(delimetr);
                String start = strUserDateStart[1] + "-" + strUserDateStart[2];
                String end = strUserDateEnd[1] + "-" + strUserDateEnd[2];
                int count = 0;
                for (int k = 0; k < listDate.size() - 1; k++) {
                    if (start.equals(listDate.get(k))) {
                        break;
                    }
                    count++;
                }
                for (int k = 1; k < listDate.size(); k++) {
                    if (end.equals(listDate.get(k))) {
                        break;
                    }
                    count++;
                }
                if (count == ((listDate.size() * 2) - 2)) {
                    listFreeNumberRoom.add(listNumberRoom.get(i));
                }
            }
        }

        return listFreeNumberRoom;
    }


}
