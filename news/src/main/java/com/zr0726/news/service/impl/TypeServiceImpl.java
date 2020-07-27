package com.zr0726.news.service.impl;

import com.zr0726.news.dao.TypeRepository;
import com.zr0726.news.po.Type;
import com.zr0726.news.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired//TypeRepository自己定义分页的类型
    private TypeRepository typeRepository;


    @Override//找到索要的页面 findAll是利用TypeRepository继承的方法来的
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }
}
