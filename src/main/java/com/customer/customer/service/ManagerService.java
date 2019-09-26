package com.customer.customer.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.customer.vo.ManagerView;

/**
 * (Manager)表服务接口
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
public interface ManagerService {

  /**
   * 登陆
   *
   * @param managerView 实例对象
   */
  void login(ManagerView managerView, HttpSession session);

  /**
   * 中介 - 微信账号获取openId
   *
   * @param request 请求参数
   * @param response 响应参数
   */
  void loginWeChat(HttpServletRequest request, HttpServletResponse response, String name)
      throws UnsupportedEncodingException;

  /**
   * 中介 - 微信账号登陆逻辑
   *
   * @param code 微信授权返回信息
   * @throws IOException
   */
  void loginCustomer(String code, HttpSession session, HttpServletResponse response, String name)
      throws IOException;

  /**
   * 鞋企 - 微信账号获取openId
   *
   * @param request 请求参数
   * @param response 响应参数
   */
  void enterpriseLoginWeChat(HttpServletRequest request, HttpServletResponse response, String type)
      throws UnsupportedEncodingException;

  /**
   * 鞋企 - 微信账号登陆逻辑
   *
   * @param code 微信授权返回信息
   * @throws IOException
   */
  void registerEnterprise(
      String code, HttpSession session, HttpServletResponse response, String type)
      throws IOException;
}
