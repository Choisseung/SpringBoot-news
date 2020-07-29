package com.zr0726.news.dao;

import com.zr0726.news.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);


}
