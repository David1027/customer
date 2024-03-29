package com.customer.customer.vo.wechat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/** Create by xesja on 2019/7/3 16:07 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {

  /** 接口调用凭证 */
  @JsonProperty("access_token")
  private String accessToken;
  /** access_token接口调用凭证超时时间，单位（秒） */
  @JsonProperty("expires_in")
  private String expiresIn;
  /** 用户刷新access_token */
  @JsonProperty("refresh_token")
  private String refreshToken;
  /** 授权用户唯一标识 */
  private String openid;
  /** 用户授权的作用域，使用逗号（,）分隔 */
  private String scope;
  /** 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。 */
  private String unionid;
}
