package com.customer.customer.vo.wechat;

import lombok.Data;

/**
 * @description: 微信授权返回结果
 * @author: lingjian
 * @create: 2019/9/6 13:37
 */
@Data
public class WeChatResult {

    /**
     * 返回状态码
     */
    private boolean code;
    /**
     * openid
     */
    private String openid;
    /**
     * 公司id
     */
    private Integer companyId;
}
