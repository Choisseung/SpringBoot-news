package com.demo.phone.web.admin;

import com.demo.phone.po.Product;
import com.demo.phone.service.ProductService;
//import com.demo.phone.service.VendorService;
import com.demo.phone.service.TrolleyService;
import com.demo.phone.vo.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")  //此功能仅面向管理员
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private TrolleyService trolleyService;

    //列表列出所有product
    @GetMapping("/productList")
    public String showProducts(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC)
                           Pageable pageable, Model model){
        model.addAttribute("page",productService.listProduct(pageable));
        return "admin/productList";
    }


    @GetMapping("/input")
    public String input(Model model){
//        setVendor(model);
        model.addAttribute("products",new Product());
        System.out.println(model.getAttribute("vendors"));
        return "admin/productAdd";
    }

    //新增产品
    @PostMapping("/productAdd")
    public String addProducts(Product products, RedirectAttributes attributes, HttpSession session){
        System.out.println("接收到的产品信息为"+products);
        Product product1;
        System.out.println(products.getId());
        if(products.getId()==null){  //新增产品
            product1 = productService.saveProduct(products);
        }else{  //修改用户
            product1 = productService.updateProduct(products.getId(),products);
            System.out.println("修改产品");
        }
        if(product1 == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/productList";
    }

    //更新产品
    @GetMapping("/products/{id}/toUpdate")
    public String toUpdate(@PathVariable Long id,Model model){
        Product products = productService.getProduct(id);
//        setVendor(model);
        model.addAttribute("products",products);
        return "admin/productUpdate";
    }

    @PostMapping("/productUpdate")
    public String updateProducts(Product products, RedirectAttributes attributes, HttpSession session){
        System.out.println("接收到的产品信息为"+products);
        Product product1;
        System.out.println(products.getId());
        if(products.getId()==null){  //新增产品
            System.out.println("没有传入id");
            product1 = productService.saveProduct(products);
        }else{  //修改用户
            product1 = productService.updateProduct(products.getId(),products);
            System.out.println("修改产品");
        }
        if(product1 == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/productList";
    }

    //删除产品
    @GetMapping("/products/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        productService.deleteProduct(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/productList";
    }

    //搜索产品  根据产品名称
    @PostMapping("/products/search")
    public String search(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC)
                         Pageable pageable, @RequestParam String query, Model model){
        model.addAttribute("page",productService.listProduct("%"+query+"%",pageable));
        model.addAttribute("query",query);
//        return "admin/productList :: productList";
        return "admin/productList";
    }

    //删除多项
    @GetMapping("/products/deleteAll")
    @ResponseBody
    public String deleteAll(String productsList){
        System.out.println(productsList);
        String[] str = productsList.split(",");
        System.out.println(str);
        for(String s:str){
            productService.deleteProduct(Long.parseLong(s));
        }
        return "admin/productList";
    }

}
