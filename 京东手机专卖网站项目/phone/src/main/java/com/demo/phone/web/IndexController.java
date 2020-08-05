package com.demo.phone.web;

import com.demo.phone.po.Product;
import com.demo.phone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.phone.Util.toSortUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/")
    public String ConvertPage(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                          Pageable pageable, Model model){
        model.addAttribute("page",productService.listProduct(pageable));
        Map map = productService.archiveProduct();
        toSortUtil.classify(model,map);
        return "main";
    }

    //显示点击的手机详情
    @RequestMapping("/phone/{id}")
    public String news(@PathVariable Long id, Model model){
        Product phone = productService.getAndConvert(id);
        model.addAttribute("phone",phone);
        return "phone";
    }





}
