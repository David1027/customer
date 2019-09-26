package com.customer.customer.dao;

import com.customer.customer.entity.Enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * (Enterprise)表数据库访问层自定义接口
 *
 * @author lingjian
 * @since 2019-09-26 11:07:12
 */
public interface EnterpriseDao
    extends JpaRepository<Enterprise, Integer>,
        JpaSpecificationExecutor<Enterprise>,
        PagingAndSortingRepository<Enterprise, Integer> {

  /**
   * 根据openid查找鞋企基类
   *
   * @param openid openid
   * @return
   */
  Enterprise findByEnterpriseOpenid(String openid);

  Enterprise findByEnterpriseName(String name);

  Enterprise findByEnterprisePhone(String phone);
}
