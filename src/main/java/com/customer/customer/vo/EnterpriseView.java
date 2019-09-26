package com.customer.customer.vo;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Enterprise)表前端展示类
 *
 * @author lingjian
 * @since 2019-09-26 11:38:18
 */
@Data
@ApiModel("Enterprise前端展示类")
public class EnterpriseView {

  @ApiModelProperty(value = "主键")
  private Integer id;

  @ApiModelProperty(value = "创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty(value = "鞋企联系人姓名")
  private String enterpriseContact;

  @ApiModelProperty(value = "鞋企公司名称")
  private String enterpriseName;

  @ApiModelProperty(value = "鞋企openid")
  private String enterpriseOpenid;

  @ApiModelProperty(value = "鞋企联系方式")
  private String enterprisePhone;

  @ApiModelProperty(value = "公司地址")
  private String enterpriseAddress;

  @ApiModelProperty(value = "企业邮箱")
  private String enterpriseEmail;

  @ApiModelProperty(value = "鞋企属性")
  private String enterpriseAttributes;

  @ApiModelProperty(value = "客户产品描述")
  private String enterpriseDescription;

  @ApiModelProperty(value = "鞋企登记上传图片")
  private String enterpriseRegisterImage;

  @ApiModelProperty(value = "鞋企签约上传图片")
  private String enterpriseSignImage;

  @ApiModelProperty(value = "是否登记")
  private Object isRegister;

  @ApiModelProperty(value = "是否签约")
  private Object isSign;
}
