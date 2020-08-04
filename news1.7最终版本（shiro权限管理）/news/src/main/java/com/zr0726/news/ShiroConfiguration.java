package com.zr0726.news;

import com.zr0726.news.realm.NewsRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    //创建realm
    @Bean
    public NewsRealm getRealm(){return new NewsRealm();}

    //创建安全管理器
    @Bean
    public SecurityManager securityManager(NewsRealm realm){
        //使用默认的安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realm);
        //将自定义realm交给安全管理器统一调度管理
        return securityManager;
    }
    //配置shiro过滤器工厂
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactory = new ShiroFilterFactoryBean();
        shiroFilterFactory.setSecurityManager(securityManager);
        //通用配置
        shiroFilterFactory.setLoginUrl("/admin");
        shiroFilterFactory.setUnauthorizedUrl("/admin");
        //键值对
        /*key：请求路径
        * value:过滤器类型
        * */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/admin/types", "perms[user-types]");
        filterMap.put("/admin/news","perms[user-news]");
        filterMap.put("/admin/tags","perms[user-tags]");
        filterMap.put("/admin/login", "anon");
        //admin/**为管理员界面
        filterMap.put("/admin/**", "authc");//第二个参数为过滤器类型

        shiroFilterFactory.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactory;

    }

    //开启shiro注释支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
