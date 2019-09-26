package com.customer.customer.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * (Enterprise)表实体类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Entity
@Table(name = "enterprise")
@Data
public class Enterprise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /** 主键 */
  private Integer id;
  /** 鞋企openid */
  @Column(name = "enterprise_openid", nullable = false)
  private String enterpriseOpenid;
  /** 客户公司名称 */
  @Column(name = "enterprise_name", nullable = false)
  private String enterpriseName;
  /** 客户联系人姓名 */
  @Column(name = "enterprise_contact", nullable = false)
  private String enterpriseContact;
  /** 客户联系方式 */
  @Column(name = "enterprise_phone", nullable = false)
  private String enterprisePhone;
  /** 客户公司地址 */
  @Column(name = "enterprise_address")
  private String enterpriseAddress;
  /** 客户企业邮箱 */
  @Column(name = "enterprise_email")
  private String enterpriseEmail;
  /** 客户属性 */
  @Column(name = "enterprise_attributes", nullable = false)
  private String enterpriseAttributes;
  /** 客户产品描述 */
  @Column(name = "enterprise_description")
  private String enterpriseDescription;
  /** 登记上传图片 */
  @Column(name = "enterprise_register_image")
  private String enterpriseRegisterImage;
  /** 签约上传图片 */
  @Column(name = "enterprise_sign_image")
  private String enterpriseSignImage;
  /** 是否登记 */
  @Column(name = "is_register", nullable = false)
  private Boolean isRegister;
  /** 是否签约 */
  @Column(name = "is_sign", nullable = false)
  private Boolean isSign;
  /** 创建时间 */
  @Column(name = " create_time", nullable = false)
  private Date createTime;
}
