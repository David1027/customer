package com.customer.customer.dao.impl;

import com.customer.common.dao.BaseRepository;
import com.customer.customer.entity.Compang;
import com.customer.customer.entity.QCompang;

/**
 * (Compang)表数据库访问层实现类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public class CompangDaoImpl extends BaseRepository {

  /**
   * 根据id获取Compang实体类对象
   *
   * @param id id
   * @return Compang对象
   */
  public Compang getCompang(Integer id) {
    QCompang qCompang = QCompang.compang;
    return queryFactory.selectFrom(qCompang).where(qCompang.id.eq(id)).fetchOne();
  }
}
