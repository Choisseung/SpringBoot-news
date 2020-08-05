package com.demo.phone.Util;

import com.demo.phone.po.Product;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class toSortUtil
{
    public static void classify(Model model, Map map){
        List<Product> vendor1 = new LinkedList<>(); //存华为
        List<Product> vendor2 = new LinkedList<>();  //存小米
        List<Product> vendor3 = new LinkedList<>();  //存苹果
        List<Product> vendor4 = new LinkedList<>();  //存三星
        List<Product> vendor5 = new LinkedList<>();  //存魅族

        System.out.println("--------------test---------");
        for(Object key:map.keySet()){
            System.out.println(key);
            if(key.equals("1")){
                vendor1 = ((List<Product>) map.get(key));
            }
            if(key.equals("2")){
                vendor2 = ((List<Product>) map.get(key));
            }
            if(key.equals("3")){
                vendor3 = ((List<Product>) map.get(key));
            }
            if(key.equals("4")){
                vendor4 = ((List<Product>) map.get(key));
            }
            if(key.equals("5")){
                vendor5 = ((List<Product>) map.get(key));
            }

        }
        //传所有
        model.addAttribute("huaweiAll",vendor1);
        model.addAttribute("xiaomiAll",vendor2);
        model.addAttribute("pingguoAll",vendor3);
        model.addAttribute("sanxingAll",vendor4);
        model.addAttribute("meizuAll",vendor5);

        //固定传排行榜
        for(int i=0;i<3;i++){
            model.addAttribute("huawei"+i,vendor1.get(i));
            model.addAttribute("xiaomi"+i,vendor2.get(i));
            model.addAttribute("pingguo"+i,vendor3.get(i));
            model.addAttribute("sanxing"+i,vendor4.get(i));
            model.addAttribute("meizu"+i,vendor5.get(i));
        }

    }
}
