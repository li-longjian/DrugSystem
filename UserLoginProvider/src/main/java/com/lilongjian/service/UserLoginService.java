package com.lilongjian.service;

import com.lilongjian.domain.LoginParam;
import com.lilongjian.domain.User;


public interface UserLoginService {
    User login(String email,String password);
}
