package com.demo.phone.service;

import com.demo.phone.po.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {

    //管理员分页展示所有产品    &&   主页分页显示
    Page<Product> listProduct(Pageable pageable);

    //新增新的产品信息
    Product saveProduct(Product product);

    //更新产品信息
    Product getProduct(Long id);
    Product updateProduct(Long id,Product product);

    //删除
    void deleteProduct(Long id);

    //query搜索
    Page<Product> listProduct(String query,Pageable pageable);

    //按厂商归类
    Map<String,List<Product>> archiveProduct();

    //跳转到手机详情
    Product getAndConvert(Long id);

    //根据id查询
    Product findById(Long id);


}
