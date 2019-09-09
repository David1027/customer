package com.customer.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beust.jcommander.internal.Nullable;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 登陆拦截器
 * @author: lingjian
 * @create: 2019/9/9 10:16
 */
@Component
public class CustomerInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
      System.out.println("preHandle");
      System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
      System.out.println(((HandlerMethod) handler).getMethod().getName());
      request.setAttribute("startTime", System.currentTimeMillis());
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable ModelAndView modelAndView)
      throws Exception {
    System.out.println("postHandle");
    Long start = (Long) request.getAttribute("startTime");
    System.out.println("time interceptor 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable Exception ex)
      throws Exception {
    System.out.println("afterCompletion");
    Long start = (Long) request.getAttribute("startTime");
    System.out.println("time interceptor 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    System.out.println("ex is : " + ex);
  }
}