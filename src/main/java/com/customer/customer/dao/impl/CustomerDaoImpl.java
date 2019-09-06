package com.customer.customer.dao.impl;

import com.customer.common.dao.BaseRepository;
import com.customer.customer.entity.Customer;
import com.customer.customer.entity.QCustomer;

/**
 * (Customer)表数据库访问层实现类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public class CustomerDaoImpl extends BaseRepository {

  /**
   * 根据id获取Customer实体类对象
   *
   * @param id id
   * @return Customer对象
   */
  public Customer getCustomer(Integer id) {
    QCustomer qCustomer = QCustomer.customer;
    return queryFactory.selectFrom(qCustomer).where(qCustomer.id.eq(id)).fetchOne();
  }
}
