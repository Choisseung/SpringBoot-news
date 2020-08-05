package com.demo.phone.service;

import com.demo.phone.po.User;

public interface UserService {
    //确认登录用户名密码
    User checkUsers(String username,String password);

    //根据用户名查找用户
    User findUserByUserName(String username);

    //注册
    void register(User user);

    //更新个人信息
    User getUser(Long id);
    User updateUser(Long id,User user);
}
