package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.Costs;
import com.github.nastyasivko.project_final.model.UserOrder;

import java.util.List;

public interface AdministratorDao {
    List<UserOrder> getUsersOrders(String nameDb);

    boolean deleteNewOrders(String nameDb, UserOrder userOrder);

    List<UserOrder> getNewOrdersForPage(String nameDb, int page);

    Long saveApprovedOrder(String nameDb, UserOrder userOrder,  Integer numberRoom, Costs cost);

    Long saveDeniedOrder(String nameDb, UserOrder userOrder);
}
