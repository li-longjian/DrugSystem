package com.lilongjian.controller;

import com.lilongjian.domain.User;
import com.lilongjian.service.UserService;
import com.lilongjian.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public Map<String, Object> UserLogin(String email, String password) {
//        Map<String, Object> map = new HashMap<>();
//        //加密密码
//        MD5Utils md5Utils = new MD5Utils();
//        String newPassword = md5Utils.getMD5(password, email);
//        User user = userService.login(email, newPassword);
//        if (user == null) {
//            map.put("msg", "用户名或密码错误");
//            return map;
//        }
//        map.put("msg", "登录成功");
//        map.put("user", user);
//        return map;
//    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/page")
    public List<User> getUserByPage(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum, @RequestParam(value = "pageSize", defaultValue = "5") String pageSize) {
        return userService.getUserByPage(pageNum, pageSize);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/getema")
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {

        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            map.put("msg", "表单信息错误");
            return map;
        }
        if (user.getEmail() == null || user.getPassword() == null) {
            map.put("msg", "用户名或密码不能为空");
            return map;
        }
        User u1 = userService.getUserByEmail(user.getEmail());
        if (u1 != null) {
            map.put("msg", "当前用户已存在！");
            return map;
        }
        System.out.println("=====================>user:" + user);
        user.setDate(new Date());
        int i = userService.registerUser(user);
        Map<String, Object> map1 = new HashMap<>();
        if (i > 0) {

            map1.put("status", "200");
            map1.put("msg", "注册成功");
        } else {
            map1.put("status", "500");
            map1.put("msg", "注册失败");
        }
        map1.put("user", user);
        return map1;
    }

    @PostMapping("/update")
    public Map<String, String> updateUser(@RequestBody User user) {

        User u1 = userService.getUserById(user.getId());
        Map<String, String> map = new HashMap<>();

        if (u1 == null) {
            map.put("msg", "没有此用户");
        } else {
            int i = userService.updateUser(user);
            if (i > 0) {
                map.put("msg", "更新成功");
            } else {
                map.put("msg", "更新失败");
            }
        }
        return map;
    }

    @GetMapping("/del/{id}")
    public Map<String, String> deleteUser(@PathVariable("id") int id) {
        User u1 = userService.getUserById(id);
        Map<String, String> map = new HashMap<>();
        if (u1 == null) {
            map.put("msg", "没有此用户");
        } else {
            int i = userService.deleteUserById(id);
            if (i > 0) {
                map.put("msg", "删除成功");
            } else {
                map.put("msg", "删除失败");
            }
        }
        return map;
    }

    @PostMapping("/find")
    public List<User> findUser(String name) {
        List<User> userList = userService.findUser(name);
        return userList;
    }


}
