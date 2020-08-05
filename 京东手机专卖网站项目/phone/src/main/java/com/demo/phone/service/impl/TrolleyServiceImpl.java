package com.demo.phone.service.impl;

import com.demo.phone.dao.TrolleyRepository;
import com.demo.phone.po.Trolley;
import com.demo.phone.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrolleyServiceImpl implements TrolleyService {

    @Autowired
    private TrolleyRepository trolleyRepository;

    @Override
    public List<Long> getTrolleyByUserId(Long id) {
        return trolleyRepository.findByUserId(id);
    }

    @Override
    public void saveTrolley(Trolley trolley) {
        trolleyRepository.save(trolley);
    }
}
