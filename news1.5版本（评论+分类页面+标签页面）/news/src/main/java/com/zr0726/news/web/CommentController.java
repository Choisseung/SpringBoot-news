//Controller都是根据用户发送的请求 来实现方法
package com.zr0726.news.web;

import com.zr0726.news.po.Comment;
import com.zr0726.news.po.User;
import com.zr0726.news.service.CommentService;
import com.zr0726.news.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private NewService newService;

    //默认头像
    private String avatar = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2515183491,81250008&fm=26&gp=0.jpg";

    @GetMapping("/comments/{newId}")
    public String comments(@PathVariable Long newId, Model model){
        model.addAttribute("comments", commentService.listCommentByNewId(newId));
        return "new::commentList";
    }

    @PostMapping("/comments")
    //发布评论方法
    public String post(Comment comment, HttpSession session){
        Long newId = comment.getNews().getId();
        //把你的新闻Id拿过来跟数据库比较查找 就可以找到这个新闻的评论
        comment.setNews(newService.getNew(newId));
        //验证判断身份是否为管理员
        User user=(User) session.getAttribute("user");
        if (user!=null){
            comment.setAdminComment(true);
            //默认头像
            comment.setAvatar(avatar);
        }else {
            comment.setAvatar(avatar);
        }
        //保存评论
        commentService.saveComment(comment);
        //保存完后暂时跳到主页
        return "redirect:/comments/"+ newId;
    }
}
