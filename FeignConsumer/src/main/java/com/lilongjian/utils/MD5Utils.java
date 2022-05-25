package com.lilongjian.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
    //定义md5算法加密
    public String getMD5(String password,String salt){
        //忽略原有密码的长度
        //for (int i = 0; i < 3; i++) {
        password= DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        //}
        return  password;
    }
}
