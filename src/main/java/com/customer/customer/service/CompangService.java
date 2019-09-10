package com.customer.customer.service;

import javax.servlet.http.HttpServletRequest;

import com.customer.common.pojo.PageView;
import com.customer.customer.vo.CompangView;

import org.apache.http.HttpRequest;
import org.springframework.data.domain.Pageable;

/**
 * (Compang)表服务接口
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public interface CompangService {

  /**
   * 新增中介公司
   *
   * @param compangView 实例对象
   * @author: lingjian @Date: 2019/9/5 16:35
   */
  Integer save(CompangView compangView);

  /**
   * 多条件分页查询所有数据
   *
   * @param pageable 分页对象
   * @return 对象列表
   */
  PageView<CompangView> listByPage(Pageable pageable);

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  CompangView getById(Integer id);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  void deleteById(Integer id);
}
