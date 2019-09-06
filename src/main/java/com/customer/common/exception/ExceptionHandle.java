package com.customer.common.exception;

import com.customer.common.enums.ResultEnum;
import com.customer.common.pojo.Result;
import com.customer.common.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 统一的异常处理
 * @author: lingjian
 * @create: 2019/8/2 9:19
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public Result handleException(Exception e) {
    log.info("异常 {}", e);
    if (e instanceof WebException) {
      WebException exception = (WebException) e;
      Integer code = exception.getCode();
      String message = exception.getMessage();
      return ResultUtil.failed(code, message);
    }
    return ResultUtil.failed(ResultEnum.FAILED);
  }
}
