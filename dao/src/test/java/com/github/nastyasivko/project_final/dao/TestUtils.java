//package com.github.nastyasivko.project_final.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TestUtils {
//
//    public static void deleteAllTable(String table) {
//        final String sql = "delete from " + table;
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void deleteRoomForNumberRoom(int number) {
//        final String sql = "delete from database_rooms where number_room = ?";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setInt(1, number);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
