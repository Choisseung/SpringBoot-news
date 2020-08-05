package com.demo.phone.po;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_product")
public class Product {

    @Id //主键标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Long id;
    private String type;
    private String productname;
    private String price;
    private String color;
    private String vendor; //厂商
    private String brand;  //品牌
    private String p_model;  //型号
    private String product_img;  //商品图片
    private Integer salesVolume;//销量
    private Integer amount; //数量
    @Temporal(TemporalType.TIMESTAMP) //指定时间戳
    private Date updateTime;



    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getP_model() {
        return p_model;
    }

    public void setP_model(String p_model) {
        this.p_model = p_model;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", productname='" + productname + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                ", vendor='" + vendor + '\'' +
                ", brand='" + brand + '\'' +
                ", p_model='" + p_model + '\'' +
                ", product_img='" + product_img + '\'' +
                ", salesVolume=" + salesVolume +
                ", amount=" + amount +
                ", updateTime=" + updateTime +
                '}';
    }
}
