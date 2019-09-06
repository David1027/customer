package com.customer.customer.vo.upload;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片上传的VO
 *
 * @author: lingjian @Date: 2019/9/6 15:23
 */
@Getter
@Setter
public class ImageView {

  /** 状态，default SUCCESS */
  private String state;

  /** 图片名称，eg. 23156121212158163121.jpg */
  private String name;

  /** 原始名称，eg. image.jpg */
  private String originalName;

  /** 文件大小 */
  private Long size;

  /** 图片的指向链接 */
  private String url;

  /** 图片类型，eg. jpg */
  private String type;

  /** 图片点击指向的链接 */
  private String link;
}
