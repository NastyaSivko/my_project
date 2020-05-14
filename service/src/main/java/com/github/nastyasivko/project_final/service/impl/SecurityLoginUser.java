//package com.github.nastyasivko.project_final.service.impl;
//
//import com.github.nastyasivko.project_final.dao.LoginUserDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultLoginUserDao;
//import com.github.nastyasivko.project_final.model.LoginUsers;
//import com.github.nastyasivko.project_final.service.LoginUser;
//
//public class SecurityLoginUser implements LoginUser {
//
//    private static class SingletonHolder {
//        static final LoginUser HOLDER_INSTANCE = new SecurityLoginUser();
//    }
//
//    public static LoginUser getInstance() {
//        return SecurityLoginUser.SingletonHolder.HOLDER_INSTANCE;
//    }
//
//    private LoginUserDao loginUserDao = DefaultLoginUserDao.getInstance();
//
//    @Override
//    public boolean dublicateLogin(String login) {
//        LoginUsers user = loginUserDao.findUser(login);
//        if (user.getName() == null && user.getPhone() == null && user.getEmail() == null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//}
