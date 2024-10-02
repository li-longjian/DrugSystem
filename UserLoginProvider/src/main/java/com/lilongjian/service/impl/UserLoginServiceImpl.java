package com.lilongjian.service.impl;

import com.lilongjian.dao.UserMapper;
import com.lilongjian.domain.LoginParam;
import com.lilongjian.domain.User;
import com.lilongjian.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User login(String email,String password) {
       // System.out.println("email:"+email+" password:"+password);
        Map<String,Object> map = new HashMap<>();
        map.put("email",email);
        map.put("password",password);
        return userMapper.login(map);
    }


}
