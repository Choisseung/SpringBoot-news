package com.zr0726.news.dao;

import com.zr0726.news.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

//指定要使用实体的类型为Type，和主键的类型为Long
public interface TypeRepository extends JpaRepository<Type,Long> {

}
