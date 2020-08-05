package com.demo.phone.dao;

import com.demo.phone.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    //插入数据

    //根据用户查看订单
    @Query("select o.productId as order from Order o where userId=?1 group by order order by o.createTime desc")
    List<Long> findByUserId(Long id);

    //根据productId查找order
    @Query("select o from Order o where o.productId=?1")
    Order findOrderByProductId(Long id);
}
