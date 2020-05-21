package com.github.nastyasivko.project_final.service;

import com.github.nastyasivko.project_final.model.LoginUsers;

public interface SecurityLoginUser {
    boolean dublicateLogin (String name, String login);
}
