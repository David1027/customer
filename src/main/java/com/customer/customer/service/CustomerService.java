package com.customer.customer.service;

import com.customer.common.pojo.PageView;
import com.customer.customer.vo.CustomerView;

import org.springframework.data.domain.Pageable;

/**
 * (Customer)表服务接口
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public interface CustomerService {

  /**
   * 新增客户
   *
   * @param customerView 实例对象
   */
  void save(CustomerView customerView);

  /**
   * 编辑客户
   *
   * @param customerView 实例对象
   */
  void update(CustomerView customerView);

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  CustomerView getById(Integer id);

  /**
   * 多条件分页查询所有数据
   *
   * @param pageable 分页对象
   * @param companyId 公司id
   * @return 对象列表
   */
  PageView<CustomerView> listByPage(Integer companyId, Pageable pageable);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  void deleteById(Integer id);
}
