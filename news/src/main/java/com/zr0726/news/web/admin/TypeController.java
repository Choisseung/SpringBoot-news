package com.zr0726.news.web.admin;

import com.zr0726.news.service.TypeService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class  TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/types")//根据id来进行分类排序 使用降序 只是定义数据显示的方式 DESC后面是传入对象
        public String type(@PageableDefault(size = 3,sort = {"id"},direction = Sort.Direction.DESC)
                                       Pageable pageable, Model model){

        //指定一个接受字段pages 利用typeservice的方法 传入pageable
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";

    }
}
