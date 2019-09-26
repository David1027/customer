package com.customer.customer.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * (Customer)表实体类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Entity
@Table(name = "customer")
@Data
public class Customer {

  @Id
  @GeneratedValue
  /** 主键 */
  @Column(name = "id", nullable = false)
  private Integer id;
  /** 客户公司名称 */
  @Column(name = "customer_name", nullable = false)
  private String customerName;
  /** 客户联系人姓名 */
  @Column(name = "customer_contact", nullable = false)
  private String customerContact;
  /** 客户联系方式 */
  @Column(name = "customer_phone", nullable = false)
  private String customerPhone;
  /** 客户公司地址 */
  @Column(name = "customer_address")
  private String customerAddress;
  /** 客户企业邮箱 */
  @Column(name = "customer_email")
  private String customerEmail;
  /** 客户属性 */
  @Column(name = "customer_attributes", nullable = false)
  private String customerAttributes;
  /** 客户产品描述 */
  @Column(name = "customer_description")
  private String customerDescription;
  /** 登记上传图片 */
  @Column(name = "customer_register_image")
  private String customerRegisterImage;
  /** 签约上传图片 */
  @Column(name = "customer_sign_image")
  private String customerSignImage;
  /** 是否登记 */
  @Column(name = "is_register", nullable = false)
  private Boolean isRegister;
  /** 是否签约 */
  @Column(name = "is_sign", nullable = false)
  private Boolean isSign;
  /** 所属中介公司id */
  @Column(name = "company_id", nullable = false)
  private Integer companyId;
  /** 创建时间 */
  @Column(name = " create_time", nullable = false)
  private Date createTime;
}
