package com.zr0726.news.service;

import com.zr0726.news.po.Comment;

import java.util.List;

public interface CommentService {

//    通过新闻的Id查看所有的评论并展示
    List<Comment> listCommentByNewId(Long newId);

    //发表评论功能 把评论保存下来
    Comment saveComment(Comment comment);


}
