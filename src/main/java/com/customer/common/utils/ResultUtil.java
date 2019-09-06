package com.customer.common.utils;

import com.customer.common.enums.ResultEnum;
import com.customer.common.pojo.Result;

/**
 * @description: 返回结果工具类
 * @author: lingjian
 * @create: 2019/7/25 13:40
 */
public class ResultUtil {

  /**
   * 执行成功并返回数据
   *
   * @param object 返回数据
   * @return Result
   * @author: lingjian @Date: 2019/7/25 13:46
   */
  public static Result success(Object object) {
    Result result = new Result();
    result.setCode(ResultEnum.SUCCESS.getCode());
    result.setMsg(ResultEnum.SUCCESS.getMessage());
    result.setResult(object);
    return result;
  }

  /**
   * 执行成功但不返回数据
   *
   * @return Result
   * @author: lingjian @Date: 2019/7/25 13:46
   */
  public static Result success() {
    return success(null);
  }

  /**
   * 执行失败返回的信息
   *
   * @param code 状态码
   * @param msg 错误信息
   * @return Result
   * @author: lingjian @Date: 2019/7/25 13:46
   */
  public static Result failed(int code, String msg) {
    Result result = new Result();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }

  /**
   * 执行失败返回的信息-重载
   *
   * @param resultEnum 返回结果枚举类
   * @return Result
   * @author: lingjian @Date: 2019/7/25 14:32
   */
  public static Result failed(ResultEnum resultEnum) {
    Result result = new Result();
    result.setCode(resultEnum.getCode());
    result.setMsg(resultEnum.getMessage());
    return result;
  }
}
