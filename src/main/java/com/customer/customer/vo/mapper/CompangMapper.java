package com.customer.customer.vo.mapper;

import java.util.Date;

import javax.print.attribute.standard.Destination;

import com.customer.customer.dao.CompangDao;
import com.customer.customer.dao.CustomerDao;
import com.customer.customer.entity.Compang;
import com.customer.customer.vo.CompangView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (Compang)的DTO和DO转换类
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
public class CompangMapper {

  private ModelMapper modelMapper = null;

  /** DO转为DTO */
  private void typeMapperDOToDTO() {
    modelMapper
        .createTypeMap(Compang.class, CompangView.class)
        .addMappings(
            mapper -> {
              mapper.map(Compang::getId, CompangView::setId);
            });
  }

  /** DTO转为DO */
  private void typeMapperDTOToDO() {
    modelMapper
        .createTypeMap(CompangView.class, Compang.class)
        .addMappings(mapper -> mapper.map(CompangView::getId, Compang::setId));
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
