package com.customer.customer.dao;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.customer.customer.entity.Manager;

/**
 * (Manager)表数据库访问层
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
public interface ManagerDao
    extends JpaRepository<Manager, Integer>,
        JpaSpecificationExecutor<Manager>,
        PagingAndSortingRepository<Manager, Integer> {
  /**
   * 通过用户名查询Manager对象
   *
   * @param username 用户名
   * @return Manager实体类
   */
  Manager findByUsername(String username);
}
