package com.lilongjian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lilongjian.dao.UserMapper;
import com.lilongjian.domain.User;
import com.lilongjian.service.UserService;
import com.lilongjian.util.MD5Utils;
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


//    @Override
//    public User login(String email,String password) {
//        Map<String,String> map = new HashMap<>();
//        map.put("email",email);
//        map.put("password",password);
//        return userMapper.login(map);
//    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<User> getUserByPage(String pageNum, String pageSize) {
        Integer page = Integer.parseInt(pageNum);
        Integer size = Integer.parseInt(pageSize);
        PageHelper.startPage(page,size);
        List<User> allUser = userMapper.getAllUser();
        return allUser;
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
        String email = user.getEmail();
        String password = user.getPassword();
        //加密密码
        MD5Utils md5Utils = new MD5Utils();
        String newPassword = md5Utils.getMD5(password, email);
        user.setPassword(newPassword);
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

    @Override
    public List<User> findUser(String name) {

        return userMapper.findUser(name);
    }
}
