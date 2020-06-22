package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.EMUtil;
import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.model.HotelRoom;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;

public class DefaultHotelRoomDao implements HotelRoomDao {
    private static final Logger log = LoggerFactory.getLogger(HotelRoomDao.class);

    private static class SingletonHolder {
        static final HotelRoomDao HOLDER_INSTANCE = new DefaultHotelRoomDao();
    }

    public static HotelRoomDao getInstance() {
        return DefaultHotelRoomDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public boolean addElement(HotelRoom room) {
//        final String sql = "insert into database_rooms(name, beds, number_room) values(?,?,?)";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, room.getName());
//            ps.setInt(2, room.getListBeds());
//            ps.setInt(3, room.getNumberRoom());
//            ps.executeUpdate();
//            log.info("room saved: {}", room);
//            return true;
//        } catch (SQLException e) {
//            log.error("fail to save room:{}", room, e);
//            throw new RuntimeException(e);
//        }
        return true;
    }

    @Override
    public boolean deleteElement(HotelRoom room) {
//        final String sql = "delete from database_rooms where number_room = ?";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setInt(1, room.getNumberRoom());
//            ps.executeUpdate();
//            log.info("room delete: {}", room);
//            return true;
//        } catch (SQLException e) {
//            log.error("fail to delete room:{}", room, e);
//            throw new RuntimeException(e);
//        }
        return true;
    }

    @Override
    public boolean updateElement(HotelRoom room) {
//        final String sql = "update database_rooms set name = ?, beds = ? where number_room = ?";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, room.getName());
//            ps.setInt(2, room.getListBeds());
//            ps.setInt(3, room.getNumberRoom());
//            ps.executeUpdate();
//            log.info("room update: {}", room);
//            return true;
//        } catch (SQLException e) {
//            log.error("fail to update room:{}", room, e);
//            throw new RuntimeException(e);
//        }
        return true;
    }

    @Override
    public List<String> getNumberRoom(String nameDb, String nameRoom, String bed) {
        Session session = EMUtil.getSession(nameDb);
        session.getTransaction().begin();
        List<String> listNumberRoom;
        try {
            listNumberRoom = session.createQuery("select h.numberRoom from HotelRoomEntity h where h.name = :name and h.beds = :bed ")
                    .setParameter("name", nameRoom)
                    .setParameter("bed", bed)
                    .getResultList();
        } catch (NoResultException e) {
            listNumberRoom = null;
        }
        session.getTransaction().commit();
        return listNumberRoom;
    }


}
