package com.zr0726.news.dao;

import com.zr0726.news.po.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewRepository extends JpaRepository<News,Long> , JpaSpecificationExecutor<News> {

    @Query("select n from News n where n.title like ?1 or n.content like ?1")
    //根据文章主题内容查询
    Page<News> findByQuery(String query, Pageable pageable);

    //凡是被推荐都会被找出来
    @Query("select n from News n where n.recommend = true ")
    List<News> findTop(Pageable pageable);
}
