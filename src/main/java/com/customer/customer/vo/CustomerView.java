package com.customer.customer.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Customer)表前端展示类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Data
@ApiModel("Customer前端展示类")
public class CustomerView {

  @ApiModelProperty(value = "主键")
  private Integer id;

  @ApiModelProperty(value = " 客户公司名称")
  private String customerName;

  @ApiModelProperty(value = " 客户联系人姓名")
  private String customerContact;

  @ApiModelProperty(value = " 客户联系方式")
  private String customerPhone;

  @ApiModelProperty(value = "公司地址")
  private String customerAddress;

  @ApiModelProperty(value = "企业邮箱")
  private String customerEmail;

  @ApiModelProperty(value = "鞋企属性")
  private String customerAttributes;

  @ApiModelProperty(value = "客户产品描述")
  private String customerDescription;

  @ApiModelProperty(value = " 登记上传图片")
  private String customerRegisterImage;

  @ApiModelProperty(value = " 签约上传图片")
  private String customerSignImage;

  @ApiModelProperty(value = "是否登记")
  private Object isRegister;

  @ApiModelProperty(value = "是否签约")
  private Object isSign;

  @ApiModelProperty(value = " 所属中介公司id")
  private Integer companyId;

  @ApiModelProperty(value = " 所属中介公司名称")
  private String companyName;

  @ApiModelProperty(value = "创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
