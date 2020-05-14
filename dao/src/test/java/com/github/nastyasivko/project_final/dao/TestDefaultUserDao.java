//package com.github.nastyasivko.project_final.dao;
//
//import com.github.nastyasivko.project_final.dao.impl.DefaultLoginUserDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultUserDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.model.Users;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import static com.github.nastyasivko.project_final.dao.TestUtils.deleteAllTable;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class TestDefaultUserDao {
//    final LoginUserDao loginUserDao = DefaultLoginUserDao.getInstance();
//    final UserDao userDao = DefaultUserDao.getInstance();
//
//    @BeforeEach
//    void deleteTable() {
//        String table = "login_users";
//        deleteAllTable(table);
//    }
//
//    @Test
//    void saveUser() {
//        String login = "user";
//        final Users user = new Users(null, "user", "user", "user", "user");
//        final Long id = userDao.save(user);
//        final LoginUsers authUser = loginUserDao.findUser(login);
//        assertNotNull(id);
//        assertEquals(user.getName(), authUser.getName());
//        assertEquals(user.getPhone(), authUser.getPhone());
//        assertEquals(user.getEmail(), authUser.getEmail());
//    }
//}
