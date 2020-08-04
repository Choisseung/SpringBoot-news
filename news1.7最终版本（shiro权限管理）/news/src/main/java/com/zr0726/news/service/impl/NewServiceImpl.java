package com.zr0726.news.service.impl;


import com.zr0726.news.NotFoundException;
import com.zr0726.news.dao.NewRepository;
import com.zr0726.news.po.News;
import com.zr0726.news.service.NewService;
import com.zr0726.news.util.MarkdownUtils;
import com.zr0726.news.util.MyBeanUtils;
import com.zr0726.news.vo.NewQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.*;

@Service
public class NewServiceImpl implements NewService {


    @Autowired
    private NewRepository newRepository;

    //新闻管理中的新闻列表（包含了查询）分页数据的展示
    @Override
    public Page<News> listNew(Pageable pageable, NewQuery newQuery) {
        return newRepository.findAll(new Specification<News>() {
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                //叠加判断
                if (!"".equals(newQuery.getTitle())&&newQuery.getTitle()!=null){
                    //根据标题进行模糊查询
                    predicates.add(cb.like(root.<String>get("title"),"%"+newQuery.getTitle()+"%"));
                }
                if (newQuery.getTypeId()!=null){//逗号前那部分指定查找的对象，后面指前面所查的东西返回的类型和值
                    predicates.add(cb.equal(root.get("type").get("id"), newQuery.getTypeId()));
                }
                if (newQuery.isRecommend()){
                    predicates.add(cb.equal(root.get("recommend"), newQuery.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public News saveNew(News news) {
        if (news.getId()==null){
            news.setCreateTime(new Date());
            news.setUpdateTime(new Date());
        }
        return newRepository.save(news);
    }


    @Override
    //根据id获取
    public News getNew(Long id) {
        return newRepository.findById(id).orElse(null);
    }

    @Override
    public News updateNew(Long id, News news) {
        News news1 = newRepository.findById(id).orElse(null);
        if (news1==null){
//            System.out.println("未获得更新对象");
            throw new NotFoundException("该新闻不存在");
        }
        BeanUtils.copyProperties(news, news1, MyBeanUtils.getNullPropertyNames(news));//空属性被忽略 不会保存
        news1.setUpdateTime(new Date());
        return newRepository.save(news1);

    }

    @Override
    public void deleteNew(Long id) {
        newRepository.deleteById(id);
    }

    //主页显示新闻列表
    @Override
    public Page<News> listNew(Pageable pageable) {
        return newRepository.findAll(pageable);
    }

    @Override
    public List<News> listRecommendNewTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable = PageRequest.of(0, size, sort);
        return newRepository.findTop(pageable);
    }

    @Override
    public Page<News> listNew(String query, Pageable pageable) {
        return newRepository.findByQuery(query, pageable);
    }

    @Override
    public News getAndConvert(Long id) {
        News news = newRepository.findById(id).orElse(null);
        if (news==null){
            System.out.println("该新闻不存在");
        }
        News news1 = new News();
        BeanUtils.copyProperties(news, news1);
        String content = news1.getContent();
        //展示出来的新闻就是html的样式了
        news1.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return news1;
    }

    //在主页分页展示
    @Override
    public Page<News> listNew(Long tagId, Pageable pageable) {
        return newRepository.findAll(new Specification<News>(){
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
               //关联查询
                Join join = root.join("tags");
                return cb.equal(join.get("id"), tagId);
            }
        },pageable);
    }

    @Override
    public Map<String, List<News>> archiveNew() {
        List<String> years = newRepository.findGroupYear();
        //hashmap是无序的集合 里面的顺序是混乱的 所以要用linkedhashmap 它是有序的
        Map<String,List<News>> map = new LinkedHashMap<>();
        for (String year:years){
            map.put(year, newRepository.findByYear(year));

        }
        return map;
    }

    @Override
    public Long countNew() {
        return newRepository.count();
    }


}
