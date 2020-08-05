package com.demo.phone.service;

import com.demo.phone.po.Order;
import com.demo.phone.po.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface OrderService {

    //向订单数据库加入数据
    Order saveOrder(Order order);

    //查询订单
    Page<Order> ListOrder(Pageable pageable);

    //根据用户id查询订单
    List<Long> getOrderByUserId(Long id);
    //根据id查询
    Order findByProductId(Long id);
}
