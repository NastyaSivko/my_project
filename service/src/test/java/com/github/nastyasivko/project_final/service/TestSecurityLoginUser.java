//package com.github.nastyasivko.project_final.service;
//
//import com.github.nastyasivko.project_final.dao.LoginUsersDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.service.impl.SecurityLoginUser;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class TestSecurityLoginUser {
//
//    @Mock
//    LoginUsersDao loginUsersDao;
//
//    @InjectMocks
//    SecurityLoginUser service;
//
//    @Test
//    void testDublicateLoginNotExist() {
//        when(loginUsersDao.findUser("user")).thenReturn(new LoginUsers(null, null, null));
//        boolean result = service.dublicateLogin("user");
//        assertTrue(result);
//    }
//
//   @Test
//    void testDublicateLoginExist() {
//       when(loginUsersDao.findUser("user")).thenReturn(new LoginUsers("user", "user", "user"));
//       boolean result = service.dublicateLogin("user");
//       assertFalse(result);
//    }
//
//}
