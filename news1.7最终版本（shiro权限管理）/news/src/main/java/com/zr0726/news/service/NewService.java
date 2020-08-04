package com.zr0726.news.service;

import com.zr0726.news.po.News;
import com.zr0726.news.vo.NewQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface NewService {

    //查询新闻 新闻管理页面，组合条件查询新闻列表
    Page<News> listNew(Pageable pageable, NewQuery newQuery);

    News saveNew(News news);

    News getNew(Long id);

    News updateNew(Long id,News news);

    //删除接口 传个id就行了
    void deleteNew(Long id);

    //主页显示新闻列表
    Page<News> listNew(Pageable pageable);

    //主页推荐最新新闻列表
    List<News> listRecommendNewTop(Integer size);

    //全局搜索
    Page<News> listNew(String query,Pageable pageable);



    //处理Mrakdown
    News getAndConvert(Long id);

    //标签页面查看新闻
    Page<News> listNew(Long tagId,Pageable pageable);

    //同事能装下String和List<News> 归档
    Map<String,List<News>> archiveNew();

    //新闻数
    Long countNew();
}
