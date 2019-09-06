package com.customer.common.controller;

import java.io.IOException;

import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;
import com.customer.common.pojo.Result;
import com.customer.common.utils.MD5Utils;
import com.customer.common.utils.OssUtils;
import com.customer.common.utils.ResultUtil;
import com.customer.customer.vo.upload.ImageView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 控制层基类
 * @author: lingjian
 * @create: 2019/9/6 15:42
 */
@RestController
@RequestMapping("/")
@Api(tags = "Controller基类")
public class BaseController {

  /**
   * 上传图片
   *
   * @param file 上传的文件
   * @return Object
   * @throws IOException
   */
  @PostMapping("upload")
  @ApiOperation("上传图片")
  public Result uploadFile(MultipartFile file) throws IOException {
    if (null == file) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "文件不能为空");
    }
    if (file.getContentType().contains("image")) {
      // 上传的是图片
    } else {
      // 上传的是文件
    }
    String oldName = file.getOriginalFilename();
    String suffix = oldName.substring(oldName.lastIndexOf("."));
    ImageView imageView = new ImageView();
    String url =
        OssUtils.upload(
            this.getClass(), MD5Utils.newGetMD5(oldName) + suffix, file.getInputStream());
    imageView.setUrl(url);
    return ResultUtil.success(imageView);
  }
}
