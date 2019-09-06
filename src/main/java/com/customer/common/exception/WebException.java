package com.customer.common.exception;

import com.customer.common.enums.ResultEnum;

import lombok.Data;

/**
 * @description: 自定义异常类
 * @author: lingjian
 * @create: 2019/7/25 14:35
 */
@Data
public class WebException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private Integer code;

  public WebException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public WebException(ResultEnum resultEnum) {
    super(resultEnum.getMessage());
    this.code = resultEnum.getCode();
  }
}
