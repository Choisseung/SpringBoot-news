package com.zr0726.news.service;

import com.zr0726.news.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    //利用SpringDate提供的分页接口Page<> 指定分页的对象为Pageable
    //Pageable对象是SpringDate库当中定义的一个接口 可以进行分页查询和数据 根据里面的参数进行数据查询并显示
    Page<Type> listType(Pageable pageable);

    //添加功能实际上是保存功能
    Type saveType(Type type);

    //查找有没有记录
    Type getTypeByName(String name);

    //删除操作
    void delete(Long id);

    //获取更新操作
    Type getType(Long id);
    Type updateType(Long id,Type type);

    //不分页的
    List<Type> listType();

}
