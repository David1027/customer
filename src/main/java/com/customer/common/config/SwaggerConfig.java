package com.customer.common.config;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: swagger在线api接口文档配置类
 * @author: lingjian
 * @create: 2019/7/13 9:36
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


  /**
   * 配置docket以配置swagger具体参数 Docket swagger-ui界面信息 apiInfo(apiInfo()) 扫描范围
   * apis(RequestHandlerSelectors.basePackage("com.shoestp.demo")) 正则过滤 paths(PathSelectors.any())
   * 忽略参数 ignoredParameterTypes(HttpSession.class) 控制swagger-ui界面展示 enable(isEnable) Boolean
   *
   * @return
   */
  @Bean
  public Docket docket(Environment environment) {
    Profiles profiles = Profiles.of("dev", "test");
    boolean isEnable = environment.acceptsProfiles(profiles);
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.customer"))
        .paths(PathSelectors.any())
        .build()
        .ignoredParameterTypes(HttpSession.class)
        .enable(isEnable);
  }

  /**
   * swagger界面基础信息配置
   *
   * @return ApiInfo
   */
  private ApiInfo apiInfo() {
    Contact contact = new Contact("David", "david.com", "123@qq.com");
    return new ApiInfo(
        "测试用swagger接口文档",
        "在测试项目中引入swagger的api接口文档",
        "v1.0",
        "http://localhost:8080",
        contact,
        "",
        "",
        new ArrayList<>());
  }
}
