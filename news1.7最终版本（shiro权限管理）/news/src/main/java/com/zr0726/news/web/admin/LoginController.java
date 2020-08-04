package com.zr0726.news.web.admin;

import com.zr0726.news.po.User;
import com.zr0726.news.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")//在端口8080+/admin才能进入Controller实行登录功能
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping//登录跳转后的页面
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){
                        //登录成功的用户密码等信息存到session中
//        User user = userService.checkUsers(username, password);
//        if (user!=null){
//            user.setPassword(null);
//            session.setAttribute("user", user);
//            return "admin/index";
//        }else {
//            attributes.addFlashAttribute("message", "用户名或密码错误");
//            return "redirect:/admin";
//        }

        try{
            //构造登录令牌
            UsernamePasswordToken uptoken = new UsernamePasswordToken(username,password);
            //获取subject
          Subject subject = SecurityUtils.getSubject();
          subject.login(uptoken);
          User user = (User) subject.getPrincipal();
          session.setAttribute("user", user);
          return "admin/index";
        }catch (Exception e){
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }
    //注销功能 就是对session进行操作 注销的话就是讲session里面的信息清除掉
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";//返回到主页上
    }
}
