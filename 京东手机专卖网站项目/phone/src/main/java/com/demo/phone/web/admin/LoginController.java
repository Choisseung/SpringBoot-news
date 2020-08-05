package com.demo.phone.web.admin;


import com.demo.phone.Util.toSortUtil;
import com.demo.phone.po.User;
import com.demo.phone.service.ProductService;
import com.demo.phone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private ProductService productService;

    @GetMapping//登录跳转后的页面
    public String loginPage(){
        return "admin/login";
    }

    public void ConvertPage(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                      Pageable pageable, Model model){
        model.addAttribute("page",productService.listProduct(pageable));
    }

    @RequestMapping("index")
    private String toIndex(){
        return "admin/main";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes,
                        @PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){
        //登录成功的用户密码等信息存到session中
        User user = userService.checkUsers(username, password);
        toSortUtil.classify(model,productService.archiveProduct());
        model.addAttribute("page",productService.listProduct(pageable));

        if (user!=null){
            user.setPassword(null);
            if(user.isAdmin()){
                user.setAdmin(true);
            }
            session.setAttribute("user", user);
            return "admin/main";
        }else {
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

    //注册功能
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String phone, @RequestParam String repassword, RedirectAttributes attributes) {
        if (password.equals(repassword)) {  //两次密码一致
            User user = userService.findUserByUserName(username);
            if (user == null) {
                User user1 = new User();
                user1.setUsername(username);
                user1.setPassword(password);
                user1.setPhone(phone);
                user1.setAdmin(false);//注册默认不是管理员
                userService.register(user1);
                attributes.addFlashAttribute("message", "注册成功");
            } else {
                attributes.addFlashAttribute("message", "用户名已经存在！");
            }
        }
        return "redirect:/admin";
    }

}
