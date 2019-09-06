package com.customer.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 返回结果
 * @author: lingjian
 * @create: 2019/7/25 13:58
 */
@Data
@ApiModel("前端返回结果展示类")
public class Result<T> {
  @ApiModelProperty(value = "状态码")
  private int code;

  @ApiModelProperty(value = "错误信息描述")
  private String msg;

  @ApiModelProperty(value = "返回结果")
  private T result;
}
