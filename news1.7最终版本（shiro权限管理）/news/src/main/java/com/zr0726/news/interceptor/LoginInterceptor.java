//package com.zr0726.news.interceptor;
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//    //登录失败拦截器
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //如果用户不存在 就拦截
//        if (request.getSession().getAttribute("user")==null){
//            response.sendRedirect("/admin");
//            return false;
//        }
//        return true;
//    }
//}
