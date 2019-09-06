package com.customer.common.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 分页前端展示类
 * @author: lingjian
 * @create: 2019/8/22 13:51
 */
@Data
@AllArgsConstructor
public class PageView<T> {

  /** 总条目数 */
  private long total;
  /** 集合对象 */
  private List<T> items;

  public static <T> PageView<T> of(long total, List<T> items) {
    return new PageView<>(total, items);
  }
}
