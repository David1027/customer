package com.customer.customer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Predicate;

import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;
import com.customer.common.pojo.PageView;
import com.customer.customer.dao.CompangDao;
import com.customer.customer.dao.CustomerDao;
import com.customer.customer.entity.Compang;
import com.customer.customer.service.CompangService;
import com.customer.customer.vo.CompangView;
import com.customer.customer.vo.mapper.CompangMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * (Compang)表服务实现类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Service("CompangService")
public class CompangServiceImpl implements CompangService {
  @Autowired private CompangDao compangDao;
  @Autowired private CustomerDao customerDao;
  private CompangMapper compangMapper = new CompangMapper();

  /**
   * 新增数据/编辑数据
   *
   * @param compangView 实例对象
   */
  @Override
  public void save(CompangView compangView) {
    compangView.setCreateTime(new Date());
    compangDao.save(compangMapper.modelMapperConfig(false).map(compangView, Compang.class));
  }

  /**
   * 分页查询所有数据
   *
   * @param pageable 分页对象
   * @return 对象列表
   */
  @Override
  public PageView<CompangView> listByPage(Pageable pageable) {
    Page<Compang> page = compangDao.findAll(pageable);
    List<CompangView> map =
        compangMapper
            .modelMapperConfig(true)
            .map(page.getContent(), new TypeToken<List<CompangView>>() {}.getType());
    map.stream()
        .peek(
            bean -> {
              bean.setRegisterCount(customerDao.countByCompanyIdAndIsRegister(bean.getId(), true));
              bean.setSignCount(customerDao.countByCompanyIdAndAndIsSign(bean.getId(), true));
            })
        .collect(Collectors.toList());
    return PageView.of(page.getTotalElements(), map);
  }

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  @Override
  public CompangView getById(Integer id) {
    if (null == compangDao.getCompang(id)) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "这个[ " + id + " ]id对应的查询结果不存在");
    }
    return compangMapper.modelMapperConfig(true).map(compangDao.getCompang(id), CompangView.class);
  }

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  @Override
  public void deleteById(Integer id) {
    compangDao.deleteById(id);
  }
}
