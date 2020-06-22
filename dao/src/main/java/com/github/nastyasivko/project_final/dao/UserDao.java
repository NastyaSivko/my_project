package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.AnswerUserOrder;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.UserOrder;
import com.github.nastyasivko.project_final.model.Users;

import java.util.List;

public interface UserDao {

    Long saveLoginUser(String nameDb,Users user, LoginUsers loginUser);
    List<AnswerUserOrder> getUserOrders(String nameDb, String login);
}
