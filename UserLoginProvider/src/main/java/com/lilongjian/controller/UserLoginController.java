package com.lilongjian.controller;

import com.lilongjian.domain.User;
import com.lilongjian.service.UserLoginService;
import com.lilongjian.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserLoginService userService;

    @PostMapping("/login")
    public Map<String, Object> UserLogin(String email, String password) {
        Map<String, Object> map = new HashMap<>();
        //加密密码
        MD5Utils md5Utils = new MD5Utils();
        String newPassword = md5Utils.getMD5(password, email);
        User user = userService.login(email, newPassword);
        if (user == null) {
            map.put("msg", "用户名或密码错误");
            return map;
        }
        map.put("msg", "登录成功");
        map.put("user", user);
        return map;
    }


}
