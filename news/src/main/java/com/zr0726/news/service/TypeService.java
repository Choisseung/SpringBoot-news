package com.zr0726.news.service;

import com.zr0726.news.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    //利用SpringDate提供的分页接口Page<> 指定分页的对象为Pageable
    //Pageable对象是SpringDate库当中定义的一个接口 可以进行分页查询和数据 根据里面的参数进行数据查询并显示
    Page<Type> listType(Pageable pageable);
}
