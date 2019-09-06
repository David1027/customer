package com.customer.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.extern.slf4j.Slf4j;

/**
 * MD5加密
 *
 * @author: lingjian @Date: 2019/9/6 15:38
 */
@Slf4j
public class MD5Utils {

  protected static char[] hexChar = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
  };

  public static String getMD5(String instr) {
    try {
      MessageDigest _md = MessageDigest.getInstance("MD5");
      _md.reset();
      byte[] in = instr.getBytes();
      _md.update(in);
      byte[] out = _md.digest();
      return toHexString(out);
    } catch (NoSuchAlgorithmException e) {
      log.error("MD5加密出错", e);
      return "";
    }
  }

  public static String toHexString(byte[] b) {
    StringBuffer sb = new StringBuffer(b.length * 2);
    for (int i = 0; i < b.length; i++) {
      sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
      sb.append(hexChar[b[i] & 0x0f]);
    }
    return sb.toString();
  }

  public static String getMD5(File file) {
    FileInputStream input = null;
    try {
      input = new FileInputStream(file);
      MappedByteBuffer buffer =
          input.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(buffer);
      BigInteger bi = new BigInteger(1, digest.digest());
      System.out.println(bi.toString(16) + "   length:" + bi.toString(16).length());
      return bi.toString(16);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  /*public static void main(String[] args) {
  	StringBuffer buffer = new StringBuffer(getMD5("666"));
  	System.out.println(buffer);
  	String substring = buffer.substring(0, buffer.length()-5);
  	System.out.println(substring);
  	String str = "";
         for (int i = 0;i<5;i++){
             str = str+ (char)(Math.random()*26+'A');
         }
         System.out.println(substring+str);
  }*/

  public static String newGetMD5(String instr) {
    try {
      MessageDigest _md = MessageDigest.getInstance("MD5");
      _md.reset();
      byte[] in = instr.getBytes();
      _md.update(in);
      byte[] out = _md.digest();
      String hexString = toHexString(out);
      String str = "";
      for (int i = 0; i < 5; i++) {
        str = str + (char) (Math.random() * 26 + 'A');
      }
      return hexString + str;
    } catch (NoSuchAlgorithmException e) {
      log.error("MD5加密出错", e);
      return "";
    }
  }

  public static String MD5Encode(String origin, String charsetname) {
    String resultString = null;
    try {
      resultString = new String(origin);
      MessageDigest md = MessageDigest.getInstance("MD5");
      if (charsetname == null || "".equals(charsetname))
        resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
      else resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
    } catch (Exception exception) {
    }
    return resultString;
  }

  private static String byteArrayToHexString(byte b[]) {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) resultSb.append(byteToHexString(b[i]));

    return resultSb.toString();
  }

  private static final String[] hexDigits = {
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
  };

  private static String byteToHexString(byte b) {
    int n = b;
    if (n < 0) n += 256;
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }
}
