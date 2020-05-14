package com.github.nastyasivko.project_final.dao;

import com.github.nastyasivko.project_final.model.Users;
import org.hibernate.Session;

public interface UserDao {

    Long saveUser(Session session, Users user);
}
