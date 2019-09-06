package com.customer.customer.controller;

import com.customer.common.pojo.Result;
import com.customer.common.utils.ResultUtil;
import com.customer.customer.service.CustomerService;
import com.customer.customer.vo.CustomerView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * (Customer)表控制层
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@RestController
@RequestMapping("/customer/")
@Api(tags = "CustomerController相关api")
public class CustomerController {
  /** 服务对象 */
  @Autowired private CustomerService customerService;

  /**
   * 新增客户
   *
   * @param customerView 实体对象
   * @return 新增结果
   */
  @PostMapping("save")
  @ApiOperation("新增客户")
  public Result save(@RequestBody CustomerView customerView) {
    customerService.save(customerView);
    return ResultUtil.success();
  }

  /**
   * 编辑客户
   *
   * @param customerView 实体对象
   * @return 新增结果
   */
  @PostMapping("update")
  @ApiOperation("编辑客户")
  public Result update(@RequestBody CustomerView customerView) {
    customerService.update(customerView);
    return ResultUtil.success();
  }

  /**
   * 根据公司id分页查询所有数据
   *
   * @param page 分页对象
   * @param size 分页对象
   * @param companyId 查询条件
   * @return 所有数据
   */
  @GetMapping("list")
  @ApiOperation("多条件分页查询所有数据")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "page", value = "开始页码", required = true, defaultValue = "0"),
    @ApiImplicitParam(name = "size", value = "显示条数", required = true, defaultValue = "20")
  })
  public Result selectAll(Integer companyId, Integer page, Integer size) {
    return ResultUtil.success(customerService.listByPage(companyId, PageRequest.of(page, size)));
  }

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("getbyid")
  @ApiOperation("通过主键查询单条数据")
  public Result getById(@RequestParam Integer id) {
    return ResultUtil.success(customerService.getById(id));
  }

  /**
   * 删除数据
   *
   * @param id 主键
   * @return 删除结果
   */
  @DeleteMapping
  @ApiOperation("删除数据")
  public Result delete(@RequestParam Integer id) {
    customerService.deleteById(id);
    return ResultUtil.success();
  }
}
