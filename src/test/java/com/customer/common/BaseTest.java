package com.customer.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * @description: 测试基类
 * @author: lingjian
 * @create: 2019/7/31 9:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BaseTest {

    @Autowired
    public MockMvc mockMvc;

    public void printResult(MvcResult mvcResult) throws Exception {
        MockHttpServletResponse response = mvcResult.getResponse();
        //得到返回码
        System.err.println("status---->" + response.getStatus());
        //得到返回结果
        System.err.println("content---->" + response.getContentAsString());
    }
}
