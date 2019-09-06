package com.customer.customer.vo.mapper;

import java.util.Date;
import com.customer.customer.entity.Customer;
import com.customer.customer.vo.CustomerView;
import org.modelmapper.ModelMapper;

/**
 * (Customer)的DTO和DO转换类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public class CustomerMapper {

  private ModelMapper modelMapper = null;

  /** DO转为DTO */
  private void typeMapperDOToDTO() {
    modelMapper
        .createTypeMap(Customer.class, CustomerView.class)
        .addMappings(mapper -> mapper.map(Customer::getId, CustomerView::setId));
  }

  /** DTO转为DO */
  private void typeMapperDTOToDO() {
    modelMapper
        .createTypeMap(CustomerView.class, Customer.class)
        .addMappings(mapper -> mapper.map(CustomerView::getId, Customer::setId));
  }

  /**
   * DO与DTO之间的转化方法
   *
   * @param flag 布尔值 true：DO->DTO，false：DTO->DO
   * @return ModelMapper对象
   */
  public ModelMapper modelMapperConfig(Boolean flag) {
    modelMapper = new ModelMapper();
    if (flag) {
      typeMapperDOToDTO();
    } else {
      typeMapperDTOToDO();
    }
    return modelMapper;
  }
}
