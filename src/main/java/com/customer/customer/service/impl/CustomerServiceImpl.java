package com.customer.customer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.Predicate;

import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;
import com.customer.common.pojo.PageView;
import com.customer.customer.dao.CompangDao;
import com.customer.customer.dao.CustomerDao;
import com.customer.customer.entity.Compang;
import com.customer.customer.entity.Customer;
import com.customer.customer.service.CustomerService;
import com.customer.customer.vo.CustomerView;
import com.customer.customer.vo.mapper.CustomerMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * (Customer)表服务实现类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
  @Autowired private CompangDao compangDao;
  @Autowired private CustomerDao customerDao;
  private CustomerMapper customerMapper = new CustomerMapper();

  /**
   * 校验客户
   *
   * @param customerView
   */
  private void verity(CustomerView customerView) {
    if (customerView.getCustomerName() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请输入与营业执照一致的公司名称");
    }
    if (customerView.getCustomerContact() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请输入公司相关负责人姓名");
    }
    if (customerView.getCustomerPhone() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请输入正确的联系方式");
    }
    if (customerView.getCustomerRegisterImage() == null
        && customerView.getCustomerSignImage() == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "请上传《客户信息登记表》或《签约合同》");
    }
    Customer customer =
        customerDao.findByCustomerNameAndCustomerContact(
            customerView.getCustomerName(), customerView.getCustomerContact());
    if (customer != null && !customer.getId().equals(customerView.getId())) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "你所添加的客户，已在平台登记");
    }
  }

  /**
   * 新增客户
   *
   * @param customerView 实例对象
   */
  @Override
  public void save(CustomerView customerView) {
    verity(customerView);
    customerView.setIsRegister(customerView.getCustomerRegisterImage() != null);
    customerView.setIsSign(customerView.getCustomerSignImage() != null);
    customerView.setCreateTime(new Date());
    customerDao.save(customerMapper.modelMapperConfig(false).map(customerView, Customer.class));
  }

  /**
   * 编辑客户
   *
   * @param customerView 实例对象
   */
  @Override
  public void update(CustomerView customerView) {
    verity(customerView);
    Optional<Customer> customer = customerDao.findById(customerView.getId());
    customerView.setIsRegister(customerView.getCustomerRegisterImage() != null);
    customerView.setIsSign(customerView.getCustomerSignImage() != null);
    customerDao.save(customerMapper.modelMapperConfig(false).map(customerView, Customer.class));
  }

  /**
   * 多条件分页查询所有数据
   *
   * @param pageable 分页对象
   * @param companyId 查询条件
   * @return 对象列表
   */
  @Override
  public PageView<CustomerView> listByPage(Integer companyId, Pageable pageable) {
    Page<Customer> page =
        customerDao.findAll(
            (root, criteriaQuery, criteriaBuilder) -> {
              List<Predicate> temp = new ArrayList<>();
              if (companyId != null) {
                temp.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("companyId"), companyId)));
              }
              return criteriaBuilder.and(temp.toArray(new Predicate[0]));
            },
            pageable);
    List<CustomerView> map =
        customerMapper
            .modelMapperConfig(true)
            .map(page.getContent(), new TypeToken<List<CustomerView>>() {}.getType());
    map.stream()
        .peek(
            bean ->
                bean.setCompanyName(
                    compangDao.findById(bean.getCompanyId()).get().getCompanyName()))
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
  public CustomerView getById(Integer id) {
    if (null == customerDao.getCustomer(id)) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "这个[ " + id + " ]id对应的查询结果不存在");
    }
    return customerMapper
        .modelMapperConfig(true)
        .map(customerDao.getCustomer(id), CustomerView.class);
  }

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  @Override
  public void deleteById(Integer id) {
    customerDao.deleteById(id);
  }
}
