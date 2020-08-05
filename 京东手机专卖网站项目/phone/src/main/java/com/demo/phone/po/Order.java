package com.demo.phone.po;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_order")
public class Order {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  //自增
    private Long id;

    private Long userId;

    private Long productId;

    private String amount;

    @Temporal(TemporalType.TIMESTAMP) //指定时间戳
    private Date createTime;

    private String img;

    private String name;

    private String sumPrice;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(String sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", amount='" + amount + '\'' +
                ", createTime=" + createTime +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", sumPrice='" + sumPrice + '\'' +
                '}';
    }
}
