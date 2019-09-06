package com.customer.customer.dao.impl;

import com.customer.common.dao.BaseRepository;
import com.customer.customer.entity.Manager;
import com.customer.customer.entity.QManager;

/**
 * (Manager)表数据库访问层实现类
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
public class ManagerDaoImpl extends BaseRepository {

  /**
   * 根据id获取Manager实体类对象
   *
   * @param id id
   * @return Manager对象
   */
  public Manager getManager(Integer id) {
    QManager qManager = QManager.manager;
    return queryFactory.selectFrom(qManager).where(qManager.id.eq(id)).fetchOne();
  }
}
