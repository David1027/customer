package com.customer.customer.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.customer.vo.ManagerView;
import com.customer.customer.vo.wechat.WeChatResult;

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
  void login(ManagerView managerView);

  /**
   * 微信账号获取openId
   *
   * @param request 请求参数
   * @param response 响应参数
   */
  void loginWeChat(HttpServletRequest request, HttpServletResponse response,String name);

  /**
   * 微信账号登陆逻辑
   *
   * @param code 微信授权返回信息
   * @throws IOException
   */
  WeChatResult loginCustomer(String code) throws IOException;

  /**
   * 微信账号注册逻辑
   *
   * @param code 微信授权返回信息
   * @return
   * @throws IOException
   */
  WeChatResult registerCustomer(String code) throws IOException;
}
