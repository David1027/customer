package com.customer.customer.controller;

import com.customer.common.pojo.Result;
import com.customer.common.utils.ResultUtil;
import com.customer.customer.service.EnterpriseService;
import com.customer.customer.vo.CustomerView;
import com.customer.customer.vo.EnterpriseView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * (Enterprise)表控制层
 *
 * @author lingjian
 * @since 2019-09-26 11:07:12
 */
@RestController
@RequestMapping("/api/enterprise/")
@Api(tags = "EnterpriseController相关api")
public class EnterpriseController {
  /** 服务对象 */
  @Autowired private EnterpriseService enterpriseService;

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("getbyid")
  @ApiOperation("通过主键查询单条数据")
  public Result getById(@RequestParam Integer id) {
    return ResultUtil.success(enterpriseService.getById(id));
  }

  /**
   * 多条件分页查询所有数据
   *
   * @param page 分页对象
   * @param size 分页对象
   * @param condition 查询条件
   * @return 所有数据
   */
  @GetMapping("list")
  @ApiOperation("多条件分页查询所有数据")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "page", value = "开始页码", required = true, defaultValue = "0"),
    @ApiImplicitParam(name = "size", value = "显示条数", required = true, defaultValue = "20")
  })
  public Result selectAll(String condition, Integer page, Integer size) {
    return ResultUtil.success(enterpriseService.listByPage(condition, PageRequest.of(page, size)));
  }

  /**
   * 新增鞋企
   *
   * @param enterpriseView 实体对象
   * @return 新增结果
   */
  @PostMapping("save")
  @ApiOperation("新增鞋企")
  public Result save(EnterpriseView enterpriseView) {
    return ResultUtil.success(enterpriseService.save(enterpriseView));
  }

  /**
   * 编辑鞋企
   *
   * @param enterpriseView 实体对象
   * @return 编辑结果
   */
  @PostMapping("update")
  @ApiOperation("编辑鞋企")
  public Result update(EnterpriseView enterpriseView) {
    enterpriseService.update(enterpriseView);
    return ResultUtil.success();
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
    enterpriseService.deleteById(id);
    return ResultUtil.success();
  }
}
