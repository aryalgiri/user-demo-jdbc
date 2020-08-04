package com.vastika.service;

import com.vastika.dao.UserDao;
import com.vastika.dao.UserDaoImpl;
import com.vastika.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();


    @Override
    public int saveUserInfo(User user) {
        return userDao.saveUserInfo(user);
    }

    @Override
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public void deleteUserInfo(int id) {
    userDao.deleteUserInfo(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUserInfo() {
        return userDao.getAllUserInfo();
    }
}
