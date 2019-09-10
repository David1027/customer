package com.customer.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beust.jcommander.internal.Nullable;
import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;
import com.customer.customer.dao.ManagerDao;
import com.customer.customer.entity.Manager;

import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired private ManagerDao managerDao;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HttpSession session = request.getSession();
    Manager login = (Manager) session.getAttribute("login");
    if (login == null) {
      throw new WebMessageException(ResultEnum.UNAUTHORIZED.getCode(), "账号未登陆，请先登陆再访问");
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable Exception ex)
      throws Exception {}
}
