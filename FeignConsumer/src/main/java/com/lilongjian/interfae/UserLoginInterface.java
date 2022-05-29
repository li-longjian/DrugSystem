package com.lilongjian.interfae;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "userLoginProvider")
public interface UserLoginInterface {
    @PostMapping("/user/login")
    Map<String, Object> UserLogin(@RequestParam("email") String email, @RequestParam("password") String password);
}
