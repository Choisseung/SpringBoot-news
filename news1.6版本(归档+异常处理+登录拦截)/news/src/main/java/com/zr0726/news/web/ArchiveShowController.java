package com.zr0726.news.web;

import com.zr0726.news.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.DocFlavor;

@Controller
public class ArchiveShowController {
    @Autowired
    private NewService newService;

    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archiveMap", newService.archiveNew());
        model.addAttribute("newsCount",newService.countNew());
//        System.out.println("显示"+ model);
        return "archives";
    }
}
