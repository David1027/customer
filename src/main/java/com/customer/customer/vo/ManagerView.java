package com.customer.customer.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Manager)表前端展示类
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
@Data
@ApiModel("Manager前端展示类")
public class ManagerView {

  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty(value = "密码")
  private String password;
}
