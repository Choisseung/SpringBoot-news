package com.demo.phone.web.admin;

import com.demo.phone.po.Order;
import com.demo.phone.po.Product;
import com.demo.phone.po.Trolley;
import com.demo.phone.po.User;
import com.demo.phone.service.ProductService;
import com.demo.phone.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TrolleyController {

    @Autowired
    private TrolleyService trolleyService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/trolley/{id}")
    public String findTrolley(@PathVariable Long id, RedirectAttributes attributes, Model model){
        List<Long> products = trolleyService.getTrolleyByUserId(id);
        List<Product> productsList = new ArrayList<>();
        for(Long pId:products){
            productsList.add(productService.findById(pId));
        }

        System.out.println("-----"+productsList.size());
        model.addAttribute("trolleyProducts",productsList);
        model.addAttribute("orders",new Order());
        System.out.println("orders已放入model");
        System.out.println(productsList.toString());
        return "admin/shoppingcart";
    }

    @RequestMapping("/trolley/add/{id}")
    public String add(@PathVariable Long id, RedirectAttributes attributes, Model model, HttpSession session){
        Trolley trolley = new Trolley();
        User user = (User) session.getAttribute("user");

        trolley.setUserId(user.getId());
        trolley.setProductId(id);
        trolleyService.saveTrolley(trolley);

        return "redirect:/admin/trolley/"+user.getId();
    }
}
