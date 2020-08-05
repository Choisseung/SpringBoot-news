package com.demo.phone.dao;

import com.demo.phone.po.Trolley;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrolleyRepository extends JpaRepository<Trolley,Long> {
    @Query("select t.productId as troller from Trolley t where userId=?1 group by troller")
    List<Long> findByUserId(Long id);


}
