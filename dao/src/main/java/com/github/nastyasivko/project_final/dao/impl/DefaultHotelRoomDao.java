//package com.github.nastyasivko.project_final.dao.impl;
//
//import com.github.nastyasivko.project_final.dao.HotelRoomsDao;
//import com.github.nastyasivko.project_final.model.HotelRoom;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.*;
//
//public class HotelRoomDao implements HotelRoomsDao {
//    private static final Logger log = LoggerFactory.getLogger(HotelRoomDao.class);
//
//    private static class SingletonHolder {
//        static final HotelRoomsDao HOLDER_INSTANCE = new HotelRoomDao();
//    }
//
//    public static HotelRoomsDao getInstance() {
//        return com.github.nastyasivko.project_final.dao.impl.HotelRoomDao.SingletonHolder.HOLDER_INSTANCE;
//    }
//
//    @Override
//    public boolean addElement(HotelRoom room) {
//        final String sql = "insert into database_rooms(name, beds, number_room) values(?,?,?)";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, room.getName());
//            ps.setInt(2, room.getBeds());
//            ps.setInt(3, room.getNumberRoom());
//            ps.executeUpdate();
//            log.info("room saved: {}", room);
//            return true;
//        } catch (SQLException e) {
//            log.error("fail to save room:{}", room, e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public boolean deleteElement(HotelRoom room) {
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
//    }
//
//    @Override
//    public boolean updateElement(HotelRoom room) {
//        final String sql = "update database_rooms set name = ?, beds = ? where number_room = ?";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, room.getName());
//            ps.setInt(2, room.getBeds());
//            ps.setInt(3, room.getNumberRoom());
//            ps.executeUpdate();
//            log.info("room update: {}", room);
//            return true;
//        } catch (SQLException e) {
//            log.error("fail to update room:{}", room, e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public HotelRoom getElement(int numberRoom) {
//        final String sql = "select * from database_rooms where number_room = ?";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setInt(1, numberRoom);
//            HotelRoom room = new HotelRoom(null, 0, 0);
//            try (ResultSet rs = ps.executeQuery()){
//                if(rs.next()) {
//                    room.setName(rs.getString("name"));
//                    room.setBeds(rs.getInt("beds"));
//                    room.setNumberRoom(numberRoom);
//                }
//            }
//            return room;
//        } catch (SQLException e) {
//            log.error("fail to get room:{}", numberRoom, e);
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
