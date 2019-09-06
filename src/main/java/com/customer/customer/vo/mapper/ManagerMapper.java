package com.customer.customer.vo.mapper;

import java.util.Date;
import com.customer.customer.entity.Manager;
import com.customer.customer.vo.ManagerView;
import org.modelmapper.ModelMapper;

/**
 * (Manager)的DTO和DO转换类
 *
 * @author lingjian
 * @since 2019-09-06 09:27:01
 */
public class ManagerMapper {

  private ModelMapper modelMapper = null;

  /** DO转为DTO */
  private void typeMapperDOToDTO() {
    modelMapper
        .createTypeMap(Manager.class, ManagerView.class)
        .addMappings(mapper -> mapper.map(Manager::getUsername, ManagerView::setUsername));
  }

  /** DTO转为DO */
  private void typeMapperDTOToDO() {
    modelMapper
        .createTypeMap(ManagerView.class, Manager.class)
        .addMappings(mapper -> mapper.map(ManagerView::getUsername, Manager::setUsername));
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
