package com.customer.customer.vo.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 微信授权返回结果
 * @author: lingjian
 * @create: 2019/9/6 13:37
 */
@Data
@ApiModel("微信授权返回结果")
public class WeChatResult {

  @ApiModelProperty(value = "返回状态码")
  private boolean code;

  @ApiModelProperty(value = "openid")
  private String openid;

  @ApiModelProperty(value = "公司id")
  private Integer companyId;

  @ApiModelProperty(value = "业务员名称")
  private String salesName;

}
