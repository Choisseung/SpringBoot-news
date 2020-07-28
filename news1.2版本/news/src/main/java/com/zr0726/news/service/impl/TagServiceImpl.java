package com.zr0726.news.service.impl;

import com.zr0726.news.dao.TagRepository;
import com.zr0726.news.po.Tag;
import com.zr0726.news.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.findById(id);
    }

    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag tag1 = tagRepository.findById(id).orElse(null);
        if (tag1==null){
            System.out.println("未获得更新对象");
            return null;
        }
        BeanUtils.copyProperties(tag, tag1);
        return tagRepository.save(tag1);

    }
}
