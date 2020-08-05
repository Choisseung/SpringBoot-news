package com.demo.phone.web.admin;

import com.demo.phone.po.User;
import com.demo.phone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")   //该功能应面向所有权限用户，不仅是admin
public class UserinfoController {
    @Autowired
    private UserService userService;


    //获取个人信息
    @GetMapping("/userinfo/{id}/toUpdate")
    public String toUpdate(@PathVariable Long id,HttpSession session, RedirectAttributes attributes, Model model){
        // 从session中获取user对象，初始化userinfo界面
        User user = userService.getUser(id);
//        User user = (User)session.getAttribute("user");
        System.out.println("userinfo:"+user);
        model.addAttribute("user",user);
        return "userinfo";  //返回userinfo
    }

     //更新个人信息功能
    @PostMapping("/userUpdate")
    public String userUpdate(User user,HttpSession session, RedirectAttributes attributes){
        System.out.println("user-update:"+user.toString());
        /**
         * user对象中的nickname,imgUrl,phone是可被修改的
         * 写入数据库时，其余属性不更新
         * 写入成功后，需将新的user对象存入session中,再返回成功信息
         */
        User user1;
        if(user.getId()==null){  //没有该用户
            System.out.println("没有传入id");
            user1 = null;
        }else{  //修改用户
            user1 = userService.updateUser(user.getId(),user);
            session.setAttribute("user", user);
            System.out.println("修改用户");
        }
        if(user1 == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");

        }

        return "admin/main";  //返回userinfo
    }

    // 修改密码功能
    @RequestMapping("/userinfo/password")
    public String password(@RequestParam String oldPassword, @RequestParam String newPassword,User user, RedirectAttributes attributes,HttpSession session){
        System.out.println("oldPassword:"+oldPassword);
        System.out.println("newPassword:"+newPassword);

        User user2;
        if(user.getId()==null){  //没有该用户
            System.out.println("没有传入id");
            user2 = null;
        }else{  //修改用户
            user.setPassword(newPassword);
            user2 = userService.updateUser(user.getId(),user);
            session.setAttribute("user", user);
            System.out.println("修改密码");
        }
        if(user2 == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");

        }

        attributes.addFlashAttribute("message","密码修改成功");
        return "admin/login";  //返回userinfo

    }

}

