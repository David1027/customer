package com.customer.customer.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * (Compang)表实体类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Entity
@Table(name = "compang")
@Data
public class Compang {

  @Id
  @GeneratedValue
  /** 主键 */
  @Column(name = "id", nullable = false)
  private Integer id;
  /** 公司名称/姓名 */
  @Column(name = "company_name", nullable = false)
  private String companyName;
  /** 联系方式 */
  @Column(name = "company_phone", nullable = false)
  private String companyPhone;

  /** 微信账号对象openid */
  @Column(name = "company_openid", nullable = false)
  private String companyOpenid;
  /** 创建时间 */
  @Column(name = " create_time", nullable = false)
  private Date createTime;
  /** 创建者/业务员名称 */
  @Column(name = " create_name", nullable = false)
  private String createName;
}
