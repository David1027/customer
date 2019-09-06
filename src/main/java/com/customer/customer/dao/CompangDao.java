package com.customer.customer.dao;

import com.customer.customer.entity.Compang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * (Compang)表数据库访问层
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public interface CompangDao
    extends JpaRepository<Compang, Integer>,
        JpaSpecificationExecutor<Compang>,
        PagingAndSortingRepository<Compang, Integer> {
  /**
   * 通过id查询Compang单个对象
   *
   * @param id id
   * @return Compang实体类
   */
  Compang getCompang(Integer id);

  /**
   * 根据openid查找公司基类
   *
   * @param openid openid
   * @return Compang实体类
   */
  Compang findByCompanyOpenid(String openid);
}
