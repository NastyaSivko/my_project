package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.UserOrder;

import java.util.List;

public interface AdministratorDao {
    List<UserOrder> getUsersOrders(String nameDb);

    boolean deleteNewOrders(String nameDb);

    List<UserOrder> getNewOrdersForPage(String nameDb, int page);
}
