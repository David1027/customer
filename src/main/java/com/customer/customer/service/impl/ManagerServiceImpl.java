package com.customer.customer.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.customer.customer.vo.wechat.WeChatResult;

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

  private static final String APP_ID = "wx61927abdbaee5455";
  private static final String SECRET = "a2795c557cd97199ed6e6148276fd489";
  private static final String REDIRECT_URI = "/api/common/login/wechat/respon";

  /**
   * 登陆逻辑
   *
   * @param managerView 实例对象
   */
  @Override
  public void login(ManagerView managerView) {
    Manager manager = managerDao.findByUsername(managerView.getUsername());
    if (manager == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "用户名不存在");
    }
    if (!managerView.getPassword().equals(manager.getPassword())) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "密码不匹配");
    }
  }

  /**
   * 公众号授权登陆
   *
   * @return url
   */
  private String getServiceConnectUri() {
    return "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
        + APP_ID
        + "&redirect_uri="
        + "https://www.shoeslogo.com/vW7s0cZNHmcN3c4i3P3hZZ.php"
        + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
  }

  /**
   * 微信账号获取openId
   *
   * @param request 请求参数
   * @param response 响应参数
   */
  @Override
  public void loginWeChat(HttpServletRequest request, HttpServletResponse response,String name) {
    String url = getServiceConnectUri();
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
  public WeChatResult loginCustomer(String code) throws IOException {
    String openid = getAccessToken(code).getOpenid();
    Compang compang = compangDao.findByCompanyOpenid(openid);
    WeChatResult result = new WeChatResult();
    if (compang == null) {
      result.setOpenid(openid);
    } else {
      result.setCode(true);
      result.setCompanyId(compang.getId());
    }
    return result;
  }

  /**
   * 微信授权后的注册逻辑
   *
   * @param code 微信授权返回信息
   * @return
   * @throws IOException
   */
  @Override
  public WeChatResult registerCustomer(String code) throws IOException {
    System.err.println("code=======>" + code);
    String openid = getAccessToken(code).getOpenid();
    Compang compang = compangDao.findByCompanyOpenid(openid);
    WeChatResult result = new WeChatResult();
    if (compang == null) {
      result.setOpenid(openid);
    } else {
      result.setCode(true);
      result.setCompanyId(compang.getId());
    }
    return result;
  }
}
