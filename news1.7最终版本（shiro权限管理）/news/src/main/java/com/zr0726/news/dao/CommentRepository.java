package com.zr0726.news.dao;

import com.zr0726.news.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//涉及数据库的操作
public interface CommentRepository extends JpaRepository<Comment,Long> {
        //把父级评论找出来即可
        //是父级评论是空的
    List<Comment> findByNewsIdAndParentCommentNull(Long newId, Sort sort);


}
