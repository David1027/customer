package com.customer.customer.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;
import com.customer.common.http.HttpRequestBuilder;
import com.customer.customer.dao.CompangDao;
import com.customer.customer.dao.ManagerDao;
import com.customer.customer.entity.Compang;
import com.customer.customer.entity.Manager;
import com.customer.customer.service.ManagerService;
import com.customer.customer.vo.wechat.AccessToken;
import com.customer.customer.vo.ManagerView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Manager)表服务实现类
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
  @Autowired private ManagerDao managerDao;
  @Autowired private CompangDao compangDao;

  private static final String NULL = "null";

  /** 微信账号的app_id */
  private static final String APP_ID = "wx61927abdbaee5455";
  /** 微信账号的密钥 */
  private static final String SECRET = "a2795c557cd97199ed6e6148276fd489";
  /** 微信授权跳转接口 */
  private static final String REDIRECT_URI = "/api/common/login/wechat/respon";
  /** 注册界面url */
  private static final String REGISTER_URI = "https://wx.shoeslogo.com/m/register";
  /** 登陆界面url */
  private static final String SIGN_URI = "https://wx.shoeslogo.com/m/agentMange";
  /** 错误界面url */
  private static final String ERROR_URI = "https://wx.shoeslogo.com/m/errorPage?type=1";

  /**
   * 登陆逻辑
   *
   * @param managerView 实例对象
   */
  @Override
  public void login(ManagerView managerView, HttpSession session) {
    Manager manager = managerDao.findByUsername(managerView.getUsername());
    if (manager == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "用户名不存在");
    }
    if (!managerView.getPassword().equals(manager.getPassword())) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "密码不匹配");
    }
    session.setAttribute("login", manager);
  }

  /**
   * 公众号授权登陆
   *
   * @return url
   */
  private String getServiceConnectUri(String name) {
    return "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
        + APP_ID
        + "&redirect_uri="
        + "https://www.shoeslogo.com/vW7s0cZNHmcN3c4i3P3hZZ.php?name="
        + name
        + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
  }

  /**
   * 微信账号获取openId
   *
   * @param request 请求参数
   * @param response 响应参数
   */
  @Override
  public void loginWeChat(HttpServletRequest request, HttpServletResponse response, String name) {
    String url = getServiceConnectUri(name);
    try {
      response.sendRedirect(url);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取accessToken
   *
   * @param code 微信授权返回信息
   * @return AccessToken
   * @throws IOException
   */
  public AccessToken getAccessToken(String code) throws IOException {
    String url =
        "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
            + APP_ID
            + "&secret="
            + SECRET
            + "&code="
            + code
            + "&grant_type=authorization_code";
    return HttpRequestBuilder.create(url, "get").fetchStringContent(AccessToken.class);
  }

  /**
   * 微信授权后的登陆逻辑
   *
   * @param code 微信授权返回信息
   * @throws IOException
   */
  @Override
  public void loginCustomer(
      String code, HttpSession session, HttpServletResponse response, String name)
      throws IOException {
    String openid = getAccessToken(code).getOpenid();
    Compang compang = compangDao.findByCompanyOpenid(openid);
    if ((!NULL.equals(name)) && compang == null) {
      response.sendRedirect(REGISTER_URI + "?Openid=" + openid + "&SalesName=" + name);
    } else if (NULL.equals(name) && compang == null) {
      response.sendRedirect(ERROR_URI);
    } else {
      response.sendRedirect(SIGN_URI + "?companyId=" + compang.getId());
    }
  }
}
