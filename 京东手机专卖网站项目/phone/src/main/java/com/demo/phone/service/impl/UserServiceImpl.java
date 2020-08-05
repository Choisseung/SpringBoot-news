package com.demo.phone.service.impl;

import com.demo.phone.dao.UserRepository;
import com.demo.phone.po.User;
import com.demo.phone.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;//引用UserRepository这个接口 帮我们找出输入的用户名和密码 这个user对象

    @Override
    public User checkUsers(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
        //引用UserRepository的findByUsernameAndPassword这个方法 如果用户名和密码错误默认返回空
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    //更新信息
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User user1 = userRepository.findById(id).orElse(null);
        if(user1==null){
            System.out.println("未获取更新对象！");
        }
        BeanUtils.copyProperties(user,user1);
        return userRepository.save(user1);
    }
}
