package com.customer.customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.common.pojo.Result;
import com.customer.common.utils.ResultUtil;
import com.customer.customer.service.ManagerService;
import com.customer.customer.vo.ManagerView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Manager)表控制层
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
@RestController
@RequestMapping("/api")
@Api(tags = "ManagerController相关api")
public class ManagerController {
  /** 服务对象 */
  @Autowired private ManagerService managerService;

  /**
   * 管理员登陆逻辑
   *
   * @param managerView 实体对象
   * @return 新增结果
   */
  @PostMapping("/manager/login")
  @ApiOperation("管理员登陆逻辑")
  public Result login(ManagerView managerView, HttpSession session) {
    managerService.login(managerView, session);
    return ResultUtil.success();
  }

  /**
   * 微信账号获取openId
   *
   * @param request 请求参数
   * @param response 响应参数
   * @return Result返回结构
   */
  @GetMapping("/manager/loginwechat")
  @ApiOperation("微信账号授权逻辑")
  public Object loginWeChat(HttpServletRequest request, HttpServletResponse response, String name) {
    managerService.loginWeChat(request, response, name);
    return ResultUtil.success();
  }

  /**
   * 微信账号注册登陆逻辑
   *
   * @param code 微信授权返回信息
   * @param session
   * @param response
   * @return Result返回结构
   * @throws IOException
   */
  @GetMapping("/common/login/wechat/respon")
  @ApiOperation("微信账号注册/登陆逻辑")
  public Object loginCustomer(
      String code, HttpSession session, HttpServletResponse response, String name)
      throws IOException {
    return ResultUtil.success(managerService.loginCustomer(code, session, response, name));
  }
}
