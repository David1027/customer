package com.customer.customer.service;

import com.customer.common.pojo.PageView;
import com.customer.customer.vo.EnterpriseView;

import org.springframework.data.domain.Pageable;

/**
 * (Enterprise)表服务接口
 *
 * @author lingjian
 * @since 2019-09-26 11:07:12
 */
public interface EnterpriseService {
  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  EnterpriseView getById(Integer id);

  /**
   * 多条件分页查询所有数据
   *
   * @param pageable 分页对象
   * @param condition 查询条件
   * @return 对象列表
   */
  PageView<EnterpriseView> listByPage(String condition, Pageable pageable);

  /**
   * 新增鞋企
   *
   * @param enterpriseView 实例对象
   */
  Integer save(EnterpriseView enterpriseView);

  /**
   * 编辑鞋企
   *
   * @param enterpriseView 实例对象
   */
  void update(EnterpriseView enterpriseView);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  void deleteById(Integer id);
}
