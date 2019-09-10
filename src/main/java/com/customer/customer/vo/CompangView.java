package com.customer.customer.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Compang)表前端展示类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Data
@ApiModel("Compang前端展示类")
public class CompangView {

  @ApiModelProperty(value = "主键")
  private Integer id;

  @ApiModelProperty(value = "公司openid")
  private String companyOpenid;

  @ApiModelProperty(value = "公司名称/姓名")
  private String companyName;

  @ApiModelProperty(value = "联系方式")
  private String companyPhone;

  @ApiModelProperty(value = "创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty(value = "创建者/业务员名称")
  private String createName;

  @ApiModelProperty(value = "登记数")
  private Integer registerCount;

  @ApiModelProperty(value = "签约数")
  private Integer signCount;

  @ApiModelProperty(value = "客户数")
  private Integer customerCount;
}
