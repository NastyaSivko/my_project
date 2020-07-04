package com.github.nastyasivko.project_final.dao.impl;

import com.github.nastyasivko.project_final.dao.*;
import com.github.nastyasivko.project_final.dao.config.DaoConfig;
import com.github.nastyasivko.project_final.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class TestDefaultUserDao {
    @Autowired
    private UserDao dao;

    @Autowired
    private LoginUserDao loginDao;

    @Test
    void testSaveUser() {
        User user = new User(null, "Nastya", "Test", "1234567");
        LoginUser loginUser = new LoginUser(null, "testlog", "testpas", null);

        long id = dao.saveLoginUser(user, loginUser);
        long idLoginUser = loginDao.getLoginUser(id).getId();


        User userEntity = dao.get(id);
        LoginUser loginUserEntity = loginDao.get(idLoginUser);

        assertNotNull(userEntity);
        assertNotNull(loginUserEntity);
        assertEquals(userEntity.getName(), user.getName());
        assertEquals(userEntity.getSurname(), user.getSurname());
        assertEquals(loginUserEntity.getLogin(), loginUser.getLogin());
        assertEquals(loginUserEntity.getPassword(), loginUser.getPassword());
    }

//    @BeforeEach
//    public void init() {
//        Session session = EMUtil.getSession(name);
//        session.getTransaction().begin();
//        session.createQuery("DELETE UserOrderEntity ").executeUpdate();
//        session.flush();
//        session.clear();
//        session.getTransaction().commit();
//        UserOrder userOrderA = new UserOrder(null, "usertestorder", "standart", "4");
//        UserOrder userOrderD = new UserOrder(null, "usertestorder", "standartroom", "5");
//        userOrderDao.saveUserOrder(name, userOrderA);
//        userOrderDao.saveUserOrder(name, userOrderD);
//        session.getTransaction().begin();
//        session.persist(new CostRoomEntity(null, 200));
//        session.getTransaction().commit();
//
//        UserOrder userOrderFromDbA = userOrderDao.getUserOrder(name, new UserOrder(null, userOrderA.getUserLogin(), userOrderA.getNameRoom(), userOrderA.getBeds()));
//        UserOrder userOrderFromDbD = userOrderDao.getUserOrder(name, new UserOrder(null, userOrderD.getUserLogin(), userOrderD.getNameRoom(), userOrderD.getBeds()));
//
//        userAdmin.saveApprovedOrder(name, userOrderFromDbA, 101, new Costs(null, 200));
//        userAdmin.saveDeniedOrder(name, userOrderFromDbD);
//    }
//
//
//    @Test
//    void testGetUserOrders() {
//        List<AnswerUserOrder> userOrders = userDao.getUserOrders(name, "usertestorder");
//
//        assertNotNull(userOrders);
//    }
}
