package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.UserOrder;

public interface UserOrderDao {

    Long saveUserOrder(String nameDb,  UserOrder userOrder);

    UserOrder getUserOrder(String nameDb, UserOrder userOrder);
}
