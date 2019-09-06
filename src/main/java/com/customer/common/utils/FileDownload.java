package com.customer.common.utils;

import java.io.*;
import java.net.URL;

import com.customer.common.enums.ResultEnum;
import com.customer.common.exception.WebMessageException;

/**
 * 文件下载
 *
 * @author: lingjian @Date: 2019/9/6 15:38
 */
public class FileDownload {

  //	private static final String default_image_suffix = "jpg";

  public static final String DEFAULT_PREFIX = "customer";

  private static final String[] IMAGE_SUFFIX_LIST = {"jpg", "jpeg", "png", "bmp", "gif"};

  public static File toTemp(String url) throws IOException {
    DataInputStream dataInputStream = null;
    FileOutputStream fileOutputStream = null;
    String suffix = getSuffix(url);
    if (suffix == null) {
      throw new WebMessageException(ResultEnum.FAILED.getCode(), "不支持的图片格式");
    }
    File temp = File.createTempFile(DEFAULT_PREFIX, suffix);
    try {
      dataInputStream = new DataInputStream(new URL(url).openStream());

      fileOutputStream = new FileOutputStream(temp);
      ByteArrayOutputStream output = new ByteArrayOutputStream();

      byte[] buffer = new byte[1024];
      int length;

      while ((length = dataInputStream.read(buffer)) > 0) {
        output.write(buffer, 0, length);
      }
      fileOutputStream.write(output.toByteArray());
    } finally {
      dataInputStream.close();
      fileOutputStream.close();
    }
    return temp;
  }

  public static String getSuffix(String url) {
    if (url.lastIndexOf(".") != -1) {
      String suffix = url.substring(url.lastIndexOf(".") + 1, url.length());
      for (String s : IMAGE_SUFFIX_LIST) {
        if (suffix.equalsIgnoreCase(s)) {
          return s;
        }
      }
    }
    return null;
  }
}
