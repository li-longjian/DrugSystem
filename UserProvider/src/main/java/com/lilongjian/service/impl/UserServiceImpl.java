package com.lilongjian.service.impl;

import com.lilongjian.dao.UserMapper;
import com.lilongjian.domain.User;
import com.lilongjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User login(String email,String password) {
        Map<String,String> map = new HashMap<>();

        map.put("email",email);
        map.put("password",password);
        return userMapper.login(map);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {

        return userMapper.getUserByEmail(email);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public int updateUser(User user) {

        User newuser = new User();
        newuser.setName(user.getName());
        newuser.setId(user.getId());
        newuser.setDate(new Date());
        newuser.setIdentity(user.getIdentity());
        newuser.setPassword(user.getPassword());
        newuser.setAvatar(user.getAvatar());
        newuser.setEmail(user.getEmail());
        newuser.setIsAdmin(user.getIsAdmin());
        return userMapper.updateUser(newuser);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }
}
