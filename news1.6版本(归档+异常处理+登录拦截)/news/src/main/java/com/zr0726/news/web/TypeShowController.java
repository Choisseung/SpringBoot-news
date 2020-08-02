package com.zr0726.news.web;

import com.zr0726.news.po.Type;
import com.zr0726.news.service.NewService;
import com.zr0726.news.service.TypeService;
import com.zr0726.news.vo.NewQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private NewService newService;

    @GetMapping("/types/{id}")
    public String type(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC)
                       Pageable pageable, @PathVariable Long id , Model model){
        List<Type> types = typeService.listTypeTop(20);
        if (id ==-1){
            //获得第一个分类的对象并获取Id
            id = types.get(0).getId();
        }
        NewQuery newQuery =new NewQuery();
        newQuery.setTypeId(id);
        model.addAttribute("types", types);
        model.addAttribute("page", newService.listNew(pageable, newQuery));
        model.addAttribute("activeTypeId", id);
        return "types";
    }

}
