package com.customer.customer.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.customer.customer.entity.Customer;

/**
 * (Customer)表数据库访问层
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public interface CustomerDao
    extends JpaRepository<Customer, Integer>,
        JpaSpecificationExecutor<Customer>,
        PagingAndSortingRepository<Customer, Integer> {
  /**
   * 通过id查询Customer单个对象
   *
   * @param id id
   * @return Customer实体类
   */
  Customer getCustomer(Integer id);

  /**
   * 根据公司名称查询记录
   * @param name 公司名称
   * @return Customer
   */
  Customer findByCustomerName(String name);

  /**
   * 根据客户公司名称和客户名称查询记录
   *
   * @param phone 联系人收集
   * @return Customer
   */
  Customer findByCustomerPhone(String phone);

  /**
   * 查询companyId的登记数的数量
   *
   * @param companyId 公司id
   * @param flag 是否登记
   * @return Integer
   */
  Integer countByCompanyIdAndIsRegister(Integer companyId, boolean flag);

  /**
   * 查询companyId的签约数的数量
   *
   * @param companyId 公司id
   * @param flag 是否签约
   * @return Integer
   */
  Integer countByCompanyIdAndAndIsSign(Integer companyId, boolean flag);

  Integer countByCompanyId(Integer companyId);
}
