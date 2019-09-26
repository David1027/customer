package com.customer.customer.vo.mapper;


import com.customer.customer.entity.Enterprise;
import com.customer.customer.vo.EnterpriseView;

import org.modelmapper.ModelMapper;

/**
 * (Enterprise)的DTO和DO转换类
 *
 * @author lingjian
 * @since 2019-09-26 11:07:12
 */
public class EnterpriseMapper {

    private ModelMapper modelMapper = null;

    /**
     * DO转为DTO
     */
    private void typeMapperDOToDTO() {
        modelMapper.createTypeMap(Enterprise.class, EnterpriseView.class).addMappings(mapper -> {
                mapper.map(Enterprise::getId, EnterpriseView::setId);
        });
    }

    /**
     * DTO转为DO
     */
    private void typeMapperDTOToDO() {
        modelMapper.createTypeMap(EnterpriseView.class, Enterprise.class).addMappings(mapper ->
                mapper.map(EnterpriseView::getId, Enterprise::setId));
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
