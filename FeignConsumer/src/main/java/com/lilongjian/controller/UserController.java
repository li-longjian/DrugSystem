package com.lilongjian.controller;

import com.lilongjian.domain.User;
import com.lilongjian.interfae.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInterface userClient;

    @PostMapping("/login")
    public Map<String, Object> UserLogin(String email, String password) {

        return userClient.UserLogin(email, password);
    }

    @GetMapping("/page")
    public List<User> getUserPage(String pageNum, String pageSize) {
        return userClient.getUserPage(pageNum, pageSize);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return userClient.getAllUser();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userClient.getUserById(id);
    }

    @PostMapping("/getema")
    public User getUserByEmail(String email) {
        return userClient.getUserByEmail(email);
    }

    @PostMapping("/register")
    public Map<String, Object> register(User user) {
        System.out.println(userClient);
        return userClient.register(user);
    }

    @PostMapping("/update")
    public Map<String, String> updateUser(User user) {
        return userClient.updateUser(user);
    }

    @GetMapping("/del/{id}")
    public Map<String, String> deleteUser(@PathVariable("id") int id) {
        return userClient.deleteUser(id);
    }

    @PostMapping("/find")
    public List<User> findUser(String name) {
        return userClient.find(name);
    }
}
