package com.lilongjian.service;

import com.github.pagehelper.PageInfo;
import com.lilongjian.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //User login(String email,String password);
    List<User> getAllUser();
    List<User> getUserByPage(String pageNum, String pageSize);
    User getUserById(int id);
    User getUserByEmail(String email);
    int registerUser(User user);
    int updateUser(User user);
    int deleteUserById(int id);
    List<User> findUser(String name);
}
