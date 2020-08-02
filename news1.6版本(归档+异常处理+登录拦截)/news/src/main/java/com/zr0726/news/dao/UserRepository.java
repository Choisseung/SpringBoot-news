package com.zr0726.news.dao;

import com.zr0726.news.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

//指定要使用实体的类型为User，和主键的类型为Long
public interface UserRepository extends JpaRepository<User,Long> {
    //根据同户名和密码返回数据库的数据
    User findByUsernameAndPassword(String username,String password);

}
