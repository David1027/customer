package com.customer.common.exception;

/**
 * @description: 异常类
 * @author: lingjian
 * @create: 2019/8/1 16:53
 */
public class WebMessageException extends WebException {

  public WebMessageException(Integer code, String errMsg) {
    super(code, errMsg);
  }
}
