package com.zr0726.news.service;

import com.zr0726.news.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    //对标签进行分页管理
    Page<Tag> listTag(Pageable pageable);

    //保存标签
    Tag saveTag(Tag tag);

    //更新操作 根据
    Tag getTagByName(String name);

    //删除标签
    void deleteTag(Long id);


    //获取标签
    Tag getTag(Long id);
    //更新标签 后保存
    Tag updateTag(Long id,Tag tag);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    //在主页显示标签分类
    List<Tag> listTagTop(Integer size);
}
