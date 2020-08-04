package com.vastika.dao;

import com.vastika.model.User;

import java.util.List;

public interface UserDao {
    int saveUserInfo(User user);
    int updateUserInfo(User user);
    void deleteUserInfo(int id);
    User getUserById(int id);

    List<User> getAllUserInfo();
}
