package com.xiaoqin.springboot03web.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandleInterceptor implements HandlerInterceptor {//拦截器


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登陆成功之后应该有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null){ //没有登陆
            request.setAttribute("msg","没有权限，请登录master test！");
            request.getRequestDispatcher("/index.html").forward(request,response);//请求转发和请求包含
            return false;
        }else{
            return true;
        }
    }
}
