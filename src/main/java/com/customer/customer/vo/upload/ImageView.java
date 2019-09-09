package com.customer.customer.vo.upload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 图片上传的VO
 *
 * @author: lingjian @Date: 2019/9/6 15:23
 */
@Getter
@Setter
@ApiModel("图片上传前端展示类")
public class ImageView {

  /** 状态，default SUCCESS */
  @ApiModelProperty(value = "状态")
  private String state;

  /** 图片名称，eg. 23156121212158163121.jpg */
  @ApiModelProperty(value = "图片名称")
  private String name;

  /** 原始名称，eg. image.jpg */
  @ApiModelProperty(value = "原始名称")
  private String originalName;

  /** 文件大小 */
  @ApiModelProperty(value = "文件大小")
  private Long size;

  /** 图片的指向链接 */
  @ApiModelProperty(value = "图片的指向链接")
  private String url;

  /** 图片类型，eg. jpg */
  @ApiModelProperty(value = "图片类型")
  private String type;

  /** 图片点击指向的链接 */
  @ApiModelProperty(value = "图片点击指向的链接")
  private String link;
}
