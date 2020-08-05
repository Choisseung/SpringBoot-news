package com.demo.phone.dao;

import com.demo.phone.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //根据同户名和密码返回数据库的数据
    User findByUsernameAndPassword(String username,String password);
    //验证
    User findByUsername(String username);
    //更新密码

}
