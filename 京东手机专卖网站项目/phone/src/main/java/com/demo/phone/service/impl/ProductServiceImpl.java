package com.demo.phone.service.impl;

import com.demo.phone.dao.ProductRepository;
import com.demo.phone.po.Product;
import com.demo.phone.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> listProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId()==null){     //如果当前id为空则为新增
            product.setUpdateTime(new Date());
            product.setSalesVolume(0);//新加产品销量为0
        }

        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product product1 = productRepository.findById(id).orElse(null);
        if(product1==null){
            System.out.println("未获取更新对象！");
        }
        BeanUtils.copyProperties(product,product1);
        product1.setUpdateTime(new Date());
        product1.setSalesVolume(product.getSalesVolume());//原始销量
        return productRepository.save(product1);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> listProduct(String query, Pageable pageable) {
        return productRepository.findByQuery(query,pageable);
    }

    @Override
    public Map<String, List<Product>> archiveProduct() {
        Map<String,List<Product>> map = new LinkedHashMap<>();
        String []vendors = new String[]{"1","2","3","4","5"};
        for(String vendor:vendors){
            map.put(vendor,productRepository.findByVendor(vendor));
            System.out.println(vendor);
        }
        System.out.println(map.toString());
        return map;
    }

    @Override
    public Product getAndConvert(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product==null){
            System.out.println("该手机不存在");
        }
        Product product1 = new Product();
        BeanUtils.copyProperties(product,product1);
        return product1;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


}
