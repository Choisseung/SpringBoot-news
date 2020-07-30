package com.zr0726.news.web.admin;

import com.zr0726.news.po.Type;
import com.zr0726.news.service.TypeService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    //判断是否存在重复分类 添加操作
    @PostMapping("/types/add") //Valid为校验
    public String add(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        //所有重复的错误
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1!=null){
            result.rejectValue("name", "nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Type type2 = typeService.saveType(type);
        if (type2==null){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    //删除操作
    @RequestMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.delete(id);
        attributes.addFlashAttribute("message", "删除成功");
        return  "redirect:/admin/types";
    }

    //更新操作
    @RequestMapping("/types/{id}/toUpdate")
    public String toUpdate(@PathVariable Long id,Model model){
        //先展示原有的数据
        System.out.println("id:"+id);
        model.addAttribute("type",typeService.getType(id));
        System.out.println("根据id传入数据为"+typeService.getType(id));
        return "admin/types-input";
    }

    @RequestMapping("/types/update/{id}")
    public String update(@Valid Type type,BindingResult result,@PathVariable Long id,RedirectAttributes attributes){
        System.out.println("传入type，"+type);
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1!=null){
            result.rejectValue("name", "nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Type type2 = typeService.updateType(id, type);
        if (type2!=null){
            attributes.addFlashAttribute("message", "更新成功");

        }
        else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        //无论页面更新成功还是失败 根据提交按钮后提交的数据
        return "redirect:/admin/types";
    }
}
