package com.zr0726.news.service.impl;

import com.zr0726.news.dao.UserRepository;
import com.zr0726.news.po.User;
import com.zr0726.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;//引用UserRepository这个接口 帮我们找出输入的用户名和密码 这个user对象

    @Override
    //
    public User checkUsers(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
        //引用UserRepository的findByUsernameAndPassword这个方法 如果用户名和密码错误默认返回空
    }
}
