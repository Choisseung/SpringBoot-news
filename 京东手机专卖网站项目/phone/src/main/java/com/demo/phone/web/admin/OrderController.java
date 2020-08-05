package com.demo.phone.web.admin;

import com.demo.phone.po.Order;
import com.demo.phone.po.Product;
import com.demo.phone.po.User;
import com.demo.phone.service.OrderService;
import com.demo.phone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

//    @RequestMapping("/showOrder/{id}")
//    public String showOrder(@PathVariable Long id,@PageableDefault(size = 30,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable,
//                            Model model){
//        model.addAttribute("orderPage",orderService.ListOrder(pageable));
//        return "admin/orderList";
//    }

    @RequestMapping("/showOrder/{id}")
    public String showOrder(@PathVariable Long id, Model model){
        List<Long> orderIds = orderService.getOrderByUserId(id);
        System.out.println("---------看看ids---------");
        System.out.println(orderIds.toString());
        List<Order> orderList = new ArrayList<>();
        for(Long oId:orderIds){
            orderList.add(orderService.findByProductId(oId));
        }
        System.out.println(orderList.toString());
        model.addAttribute("orderList",orderList);
        return "admin/orderList";
    }


    @RequestMapping("/orderAdd/{id}")
    public String addOrder(@PathVariable Long id, HttpSession session, Order order){
        if(order.getAmount()==null){
            System.out.println("没有传入订单进来");
        }
        //根据手机id获取手机的信息
        Product product = productService.findById(id);
        System.out.println(product.toString());
        //获取当前登陆用户
        User user = (User) session.getAttribute("user");

        //如果order中有了该id的物品

        //给order传值
        order.setProductId(id);
        order.setImg(product.getProduct_img());
        order.setName(product.getProductname());
        Double sum = Double.parseDouble(product.getPrice())*Double.parseDouble(order.getAmount());
        order.setSumPrice(sum.toString());
        order.setUserId(user.getId());
        order.setCreateTime(new Date());
        orderService.saveOrder(order);  //订单加入成功  对应物品数量-1 销量+1
        product.setAmount(product.getAmount()- Integer.parseInt(order.getAmount()));
        product.setSalesVolume(product.getSalesVolume()+ Integer.parseInt(order.getAmount()));
        productService.updateProduct(id,product);
        return "redirect:/admin/showOrder/"+user.getId();
    }
}
