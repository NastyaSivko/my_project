package com.github.nastyasivko.project_final.dao.converter;

import com.github.nastyasivko.project_final.dao.entity.LoginUsersEntity;
import com.github.nastyasivko.project_final.model.LoginUsers;

public class LoginUserConverter {
    public static LoginUsersEntity toEntity(LoginUsers loginUser) {
        if (loginUser == null) {
            return null;
        }
        final LoginUsersEntity loginUserEntity = new LoginUsersEntity();
        loginUserEntity.setId(loginUser.getId());
        loginUserEntity.setLogin(loginUser.getLogin());
        loginUserEntity.setPassword(loginUser.getPassword());
        loginUserEntity.setUserId(loginUser.getUserId());
        return loginUserEntity;
    }

    public static LoginUsers fromEntity(LoginUsersEntity loginUserEntity) {
        if (loginUserEntity == null) {
            return null;
        }
        return new LoginUsers(
                loginUserEntity.getId(),
                loginUserEntity.getLogin(),
                loginUserEntity.getPassword(),
                loginUserEntity.getUserId());
    }
}
