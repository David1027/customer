package com.customer.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 返回状态枚举
 * @author: lingjian
 * @create: 2019/7/25 14:01
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
  /** 返回结果状态 */
  SUCCESS(200, "操作成功"),
  FAILED(500, "操作失败"),
  VALIDATE_FAILED(404, "参数检验失败"),
  UNAUTHORIZED(401, "暂未登录或token已经过期"),
  FORBIDDEN(403, "没有相关权限");

  private int code;
  private String message;
}
