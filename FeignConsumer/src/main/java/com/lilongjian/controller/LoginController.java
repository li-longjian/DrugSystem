package com.lilongjian.controller;

import com.lilongjian.interfae.UserLoginInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserLoginInterface loginClient;

    @PostMapping("/login")
    public Map<String, Object> UserLogin(String email, String password){
        return loginClient.UserLogin(email,password);
    }
}
