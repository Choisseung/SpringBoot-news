package com.demo.phone.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 */
@Entity
@Table(name = "m_trolley")
public class Trolley {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  //自增
    private Long id;

    private Long userId;

    private Long productId;

    public Trolley() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
