//package com.github.nastyasivko.project_final.dao.impl;
//
//import com.github.nastyasivko.project_final.dao.LoginUserDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//
//import java.sql.*;
//
//public class DefaultLoginUserDao implements LoginUserDao {
//
//    private static class SingletonHolder {
//        static final LoginUserDao HOLDER_INSTANCE = new DefaultLoginUserDao();
//    }
//
//    public static LoginUserDao getInstance() {
//        return DefaultLoginUserDao.SingletonHolder.HOLDER_INSTANCE;
//    }
//
//    @Override
//    public LoginUsers findUser(String login) {
//        final String sql = "select * from login_users where login = ?";
//        try (//Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, login);
//            LoginUsers authUser = new LoginUsers(null, null, null);
//            try (ResultSet rs = ps.executeQuery()){
//                if(rs.next()) {
//                   authUser.setName(rs.getString("name"));
//                   authUser.setPhone(login);
//                   authUser.setEmail(rs.getString("password"));
//                }
//            }
//            return authUser;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
