package com.customer.customer.controller;

import com.customer.common.pojo.Result;
import com.customer.common.utils.ResultUtil;
import com.customer.customer.service.CompangService;
import com.customer.customer.vo.CompangView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * (Compang)中介公司表控制层
 *
 * @author lingjian
 * @since 2019-09-05 16:17:20
 */
@RestController
@RequestMapping("/api/compang/")
@Api(tags = "CompangController相关api")
public class CompangController {
  /** 服务对象 */
  @Autowired private CompangService compangService;

  /**
   * 新增中介公司
   *
   * @param compangView 实体对象
   * @return 新增结果
   * @author: lingjian @Date: 2019/9/5 16:35
   */
  @PostMapping("save")
  @ApiOperation("新增中介公司")
  public Result save(CompangView compangView) {
    compangService.save(compangView);
    return ResultUtil.success();
  }

  /**
   * 多条件分页查询所有数据
   *
   * @param page 分页对象
   * @param size 分页对象
   * @return 所有数据
   */
  @GetMapping("list")
  @ApiOperation("分页查询所有数据")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "page", value = "开始页码", required = true, defaultValue = "0"),
    @ApiImplicitParam(name = "size", value = "显示条数", required = true, defaultValue = "20")
  })
  public Result selectAll(Integer page, Integer size) {
    return ResultUtil.success(compangService.listByPage(PageRequest.of(page, size)));
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
    return ResultUtil.success(compangService.getById(id));
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
    compangService.deleteById(id);
    return ResultUtil.success();
  }
}
