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

    //SELECT date_format(n.upadte_time,'%Y') FROM t_news n GROUP BY DATE_FORMAT(n.update_time,'%Y') ORDER BY DATE_FORMAT(n.update_time,'%Y') DESC
    @Query("select function('date_format',n.updateTime,'%Y') as year from News n group by year order by year desc ")
    List<String> findGroupYear();

    //根据更新日期显示新闻
    @Query("select n from  News n where function('date_format',n.updateTime,'%Y') =?1")//表示传进去的参数有很多个
    List<News> findByYear(String year);
}
