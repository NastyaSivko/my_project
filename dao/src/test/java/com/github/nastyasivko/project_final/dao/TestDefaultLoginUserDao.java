//package com.github.nastyasivko.project_final.dao;
//
//import com.github.nastyasivko.project_final.dao.impl.DefaultLoginUserDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultUserDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.model.Users;
//import org.junit.jupiter.api.*;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class TestDefaultLoginUserDao {
//    final LoginUserDao loginUserDao = DefaultLoginUserDao.getInstance();
//    final UserDao userDao = DefaultUserDao.getInstance();
//
//    @BeforeEach
//    void deleteTable() {
//        final String sql = "delete from login_users";
//        try (Connection connection = DataSource.getInstance().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    void findUser() {
//        String login = "user";
//        final Users user = new Users(null, "user", "user", "user", "user");
//        final Long id = userDao.save(user);
//        final LoginUsers authUser = loginUserDao.findUser(login);
//        assertNotNull(authUser);
//        assertEquals(user.getName(), authUser.getName());
//        assertEquals(user.getPhone(), authUser.getPhone());
//        assertEquals(user.getEmail(), authUser.getEmail());
//    }
//
//}
