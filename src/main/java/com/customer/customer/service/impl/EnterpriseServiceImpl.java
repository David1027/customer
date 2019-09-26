package com.customer.customer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;
import com.customer.common.pojo.PageView;
import com.customer.customer.dao.EnterpriseDao;
import com.customer.customer.entity.Customer;
import com.customer.customer.entity.Enterprise;
import com.customer.customer.service.EnterpriseService;
import com.customer.customer.vo.CustomerView;
import com.customer.customer.vo.EnterpriseView;
import com.customer.customer.vo.mapper.EnterpriseMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * (Enterprise)表服务实现类
 *
 * @author lingjian
 * @since 2019-09-26 11:07:12
 */
@Service("EnterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {
  @Autowired private EnterpriseDao enterpriseDao;
  private EnterpriseMapper enterpriseMapper = new EnterpriseMapper();

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  @Override
  public EnterpriseView getById(Integer id) {
    if (!enterpriseDao.findById(id).isPresent()) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "这个[ " + id + " ]id对应的查询结果不存在");
    }
    return enterpriseMapper
        .modelMapperConfig(true)
        .map(enterpriseDao.findById(id).get(), EnterpriseView.class);
  }

  /**
   * 多条件分页查询所有数据
   *
   * @param pageable 分页对象
   * @param condition 查询条件
   * @return 对象列表
   */
  @Override
  public PageView<EnterpriseView> listByPage(String condition, Pageable pageable) {
    Page<Enterprise> page =
        enterpriseDao.findAll(
            (root, criteriaQuery, criteriaBuilder) -> {
              List<Predicate> temp = new ArrayList<>();
              if (condition != null) {
                temp.add(
                    criteriaBuilder.and(
                        criteriaBuilder.like(root.get("id"), "%" + condition + "%")));
              }
              return criteriaBuilder.and(temp.toArray(new Predicate[0]));
            },
            pageable);
    return PageView.of(
        page.getTotalElements(),
        enterpriseMapper
            .modelMapperConfig(true)
            .map(page.getContent(), new TypeToken<List<EnterpriseView>>() {}.getType()));
  }

  /**
   * 校验客户
   *
   * @param enterpriseView
   */
  private void verity(EnterpriseView enterpriseView) {
    if (enterpriseView.getEnterpriseName() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请输入与营业执照一致的公司名称");
    }
    if (enterpriseView.getEnterpriseContact() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请输入公司相关负责人姓名");
    }
    if (enterpriseView.getEnterprisePhone() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请输入正确的联系方式");
    }
    if (enterpriseView.getEnterpriseRegisterImage() == null
        && enterpriseView.getEnterpriseSignImage() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请上传《客户信息登记表》或《签约合同》");
    }

    Enterprise enterpriseName =
        enterpriseDao.findByEnterpriseName(enterpriseView.getEnterpriseName());
    if (enterpriseName != null && !enterpriseName.getId().equals(enterpriseView.getId())) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "你所添加的客户公司名称，已在平台登记");
    }

    Enterprise enterprisePhone =
        enterpriseDao.findByEnterprisePhone(enterpriseView.getEnterprisePhone());
    if (enterprisePhone != null && !enterprisePhone.getId().equals(enterpriseView.getId())) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "你所添加的客户手机，已在平台登记");
    }
  }

  /**
   * 新增鞋企
   *
   * @param enterpriseView 实例对象
   */
  @Override
  public Integer save(EnterpriseView enterpriseView) {
    verity(enterpriseView);
    enterpriseView.setIsRegister(enterpriseView.getEnterpriseRegisterImage() != null);
    enterpriseView.setIsSign(enterpriseView.getEnterpriseSignImage() != null);
    enterpriseView.setCreateTime(new Date());
    Enterprise result =
        enterpriseDao.save(
            enterpriseMapper.modelMapperConfig(false).map(enterpriseView, Enterprise.class));
    return result.getId();
  }

  /**
   * 编辑鞋企
   *
   * @param enterpriseView 实例对象
   */
  @Override
  public void update(EnterpriseView enterpriseView) {
    verity(enterpriseView);
    Optional<Enterprise> enterprise = enterpriseDao.findById(enterpriseView.getId());
    enterpriseView.setIsRegister(enterpriseView.getEnterpriseRegisterImage() != null);
    enterpriseView.setIsSign(enterpriseView.getEnterpriseSignImage() != null);
    enterpriseView.setCreateTime(enterprise.get().getCreateTime());
    enterpriseDao.save(
        enterpriseMapper.modelMapperConfig(false).map(enterpriseView, Enterprise.class));
  }

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  @Override
  public void deleteById(Integer id) {
    enterpriseDao.deleteById(id);
  }
}
