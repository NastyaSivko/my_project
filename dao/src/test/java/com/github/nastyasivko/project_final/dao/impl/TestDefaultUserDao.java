package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.*;
import com.github.nastyasivko.project_final.dao.entity.*;
import com.github.nastyasivko.project_final.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TestDefaultUserDao {
    final UserDao userDao = DefaultUserDao.getInstance();
    final LoginUsersDao loginUserDao = DefaultLoginUsersDao.getInstance();
    final UserOrderDao userOrderDao = DefaultUserOrderDao.getInstance();
    final AdministratorDao userAdmin = UserAdministratorDao.getInstance();
    final String name = "project_test";


    @Test
    void testSaveUser() {
        final Session session = EMUtil.getSession(name);
        Users user = new Users(null, "Nastya", "Test", "1234567");
        LoginUsers loginUser = new LoginUsers(null, "testlog", "testpas", null);

        long id = userDao.saveLoginUser(name, user, loginUser);
        long idLoginUser = loginUserDao.getLoginUserForUserId(name, id).getId();


        UserEntity userEntity = session.get(UserEntity.class, id);
        LoginUsersEntity loginUsersEntity = session.get(LoginUsersEntity.class, idLoginUser);

        assertNotNull(userEntity);
        assertEquals(userEntity.getName(), user.getName());
        assertEquals(userEntity.getSurname(), user.getSurname());
        assertEquals(loginUsersEntity.getLogin(), loginUsersEntity.getLogin());
        assertEquals(loginUsersEntity.getPassword(), loginUsersEntity.getPassword());
        assertEquals(userEntity.getId(), loginUsersEntity.getUserEntity().getId());
    }

    @BeforeEach
    public void init() {
        Session session = EMUtil.getSession(name);
        session.getTransaction().begin();
        session.createQuery("DELETE UserOrderEntity ").executeUpdate();
        session.flush();
        session.clear();
        session.getTransaction().commit();
        UserOrder userOrderA = new UserOrder(null, "usertestorder", "standart", "4");
        UserOrder userOrderD = new UserOrder(null, "usertestorder", "standartroom", "5");
        userOrderDao.saveUserOrder(name, userOrderA);
        userOrderDao.saveUserOrder(name, userOrderD);
        session.getTransaction().begin();
        session.persist(new CostRoomsEntity(null, 200));
        session.getTransaction().commit();

        UserOrder userOrderFromDbA = userOrderDao.getUserOrder(name, new UserOrder(null, userOrderA.getUserLogin(), userOrderA.getNameRoom(), userOrderA.getBeds()));
        UserOrder userOrderFromDbD = userOrderDao.getUserOrder(name, new UserOrder(null, userOrderD.getUserLogin(), userOrderD.getNameRoom(), userOrderD.getBeds()));

        userAdmin.saveApprovedOrder(name, userOrderFromDbA, 101, new Costs(null, 200));
        userAdmin.saveDeniedOrder(name, userOrderFromDbD);
    }


    @Test
    void testGetUserOrders() {
        List<AnswerUserOrder> userOrders = userDao.getUserOrders(name, "usertestorder");

        assertNotNull(userOrders);
    }
}
