package com.demo.phone.service.impl;

import com.demo.phone.dao.OrderRepository;
import com.demo.phone.po.Order;
import com.demo.phone.po.Product;
import com.demo.phone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> ListOrder(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public List<Long> getOrderByUserId(Long id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public Order findByProductId(Long id) {
        return orderRepository.findOrderByProductId(id);
    }


}
