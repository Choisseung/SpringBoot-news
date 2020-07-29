package com.zr0726.news.service;

import com.zr0726.news.po.News;
import com.zr0726.news.vo.NewQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewService {

    Page<News> listNew(Pageable pageable, NewQuery newQuery);

    News saveNew(News news);

    News getNew(Long id);

    News updateNew(Long id,News news);

}
