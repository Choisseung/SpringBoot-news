package com.demo.phone.dao;

import com.demo.phone.po.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //根据商品名称模糊查询
    @Query("select p from Product p where p.productname like ?1")
    Page<Product> findByQuery(String query, Pageable pageable);

    //根据厂商进行分类
//    @Query("select p as vendor from Product p where vendor = ?1 group by vender ")
//    List<String> findGroupVendor();
    //通过vendor进行查询
    @Query("select p from Product p where vendor = ?1 order by sales_volume desc")
    List<Product> findByVendor(String vendor);


}
