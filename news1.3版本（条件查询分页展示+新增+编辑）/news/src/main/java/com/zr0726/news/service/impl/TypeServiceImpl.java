package com.zr0726.news.service.impl;

import com.zr0726.news.dao.TypeRepository;
import com.zr0726.news.po.Type;
import com.zr0726.news.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//引用dao层的接口
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired//TypeRepository自己定义分页的类型
    private TypeRepository typeRepository;


    @Override//找到索要的页面 findAll是利用TypeRepository继承的方法来的
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    @Override//拿到Type
    public Type getType(Long id) {
        return typeRepository.findById(id).orElse(null);//findOne(id)已过时
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type type1 = typeRepository.findById(id).orElse(null);
        if (type1==null){
            System.out.println("未获得更新对象");
            return null;
        }
        //复制外面传进来的对象type 给type1
        BeanUtils.copyProperties(type, type1);
        return typeRepository.save(type1);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


}
