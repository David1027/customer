package com.customer.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * @description: 自定义错误信息JSON值
 * @author: lingjian
 * @create: 2019/8/1 17:28
 */
@Component
public class ErrorAtributesException extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean flag) {
    Map<String, Object> map = super.getErrorAttributes(webRequest, flag);
    String code = map.get("status").toString();
    String message = map.get("error").toString();
    map.remove("status");
    map.remove("error");
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("code", code);
    hashMap.put("message", message);
    hashMap.put("data", map);
    return hashMap;
  }
}
