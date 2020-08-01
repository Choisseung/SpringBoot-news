package com.zr0726.news.service.impl;

import com.zr0726.news.dao.CommentRepository;
import com.zr0726.news.po.Comment;
import com.zr0726.news.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    //根据新闻Id绑定所有的新闻评论
    public List<Comment> listCommentByNewId(Long newId) {
        //定义评论排序的规则
        Sort sort = Sort.by("createTime");
        List<Comment> comments = commentRepository.findByNewsIdAndParentCommentNull(newId, sort);
        return eachComment(comments);
    }

    //循环获取分级评论
    private List<Comment> eachComment(List<Comment> comments){
        //commentsView是个集合
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment:comments){
            Comment c = new Comment();
            BeanUtils.copyProperties(comment, c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    //合并父子评论
    private void combineChildren(List<Comment> comments){
        for (Comment comment:comments){
            //获取评论回复
            List<Comment> replys1 =comment.getReplyComments();
            //找出那条评论的子评论
            for (Comment reply1:replys1){
                //把每一条评论的子回复都获取 使用循环迭代 找出子代，存放在临时tempReplys中
                recursively(reply1);
            }
            comment.setReplyComments(tempReplys);
            //清空临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //设置临时存放区
    private List<Comment> tempReplys = new ArrayList<>();

    //不停的找子回复 然后通通存到临时存放区
    private void recursively(Comment comment){
        tempReplys.add(comment);        //comment为顶节点 把他添加到临时存放区
        if (comment.getReplyComments().size()>0){//获取顶节点的回复大于0 就是有回复
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply:replys){//把单独的每条评论添加
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0){
                    recursively(reply);
                }
            }
        }
    }






    @Override
    //传进来comment对象为参数
    public Comment saveComment(Comment comment) {
        //先把父级评论的对象提取
        Long parenCommentId = comment.getParentComment().getId();
        //再把父级评论的Id提取
        if (parenCommentId!=-1){
            comment.setParentComment(commentRepository.findById(parenCommentId).orElse(null));
        }
        //没有父级评论
        else{
            comment.setParentComment(null);
        }
        //创建时间
        comment.setCreateTime(new Date());

        return commentRepository.save(comment);
    }
}
