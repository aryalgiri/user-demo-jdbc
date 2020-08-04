package com.vastika.service;

import com.vastika.model.User;

import java.util.List;

public interface UserService {
    int saveUserInfo(User user);
    int updateUserInfo(User user);
    void deleteUserInfo(int id);
    User getUserById(int id);

    List<User> getAllUserInfo();
}
