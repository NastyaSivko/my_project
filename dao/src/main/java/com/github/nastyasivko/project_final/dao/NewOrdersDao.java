package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.UserOrder;

public interface NewOrdersDao {

    boolean saveNewOrder(String nameDb,  UserOrder userOrder);
}
