package com.customer.customer.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * (Manager)表实体类
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
@Entity
@Table(name = "manager")
@Data
public class Manager {

  @Id
  @GeneratedValue
  /** 主键 */
  @Column(name = "id")
  private Integer id;
  /** 用户名 */
  @Column(name = "username")
  private String username;
  /** 密码 */
  @Column(name = "password")
  private String password;
  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
