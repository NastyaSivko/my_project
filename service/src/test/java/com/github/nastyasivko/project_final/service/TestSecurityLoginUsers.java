package com.github.nastyasivko.project_final.service;

import com.github.nastyasivko.project_final.dao.LoginUsersDao;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.service.impl.SecurityLoginUsers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestSecurityLoginUsers {
    final String name="project_test";

    @Mock
    LoginUsersDao loginUsersDao;

    @InjectMocks
    SecurityLoginUsers service;

    @Test
    void testDublicateLoginNotExist() {
        when(loginUsersDao.findLoginUser(name,"user")).thenReturn(null);
        boolean result = service.dublicateLogin(name,"user");
        assertTrue(result);
    }

   @Test
    void testDublicateLoginExist() {
       when(loginUsersDao.findLoginUser(name,"user")).thenReturn(new LoginUsers(null, "user", "user", null));
       boolean result = service.dublicateLogin(name,"user");
       assertFalse(result);
    }

}
