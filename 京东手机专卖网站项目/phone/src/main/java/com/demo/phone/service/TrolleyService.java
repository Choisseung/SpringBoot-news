package com.demo.phone.service;

import com.demo.phone.po.Trolley;

import java.util.List;

public interface TrolleyService {
    //根据用户id查询购物车
    List<Long> getTrolleyByUserId(Long id);

    //新增数据
    void saveTrolley(Trolley trolley);
}
