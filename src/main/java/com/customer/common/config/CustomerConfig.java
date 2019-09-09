package com.customer.common.config;

import com.customer.common.interceptor.CustomerInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: 配置类
 * @author: lingjian
 * @create: 2019/9/9 10:24
 */
@Configuration
public class CustomerConfig extends WebMvcConfigurationSupport {

  @Autowired private CustomerInterceptor customerInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(customerInterceptor)
        .addPathPatterns("/**")
            .excludePathPatterns("/swagger-ui.html")
            .excludePathPatterns("/swagger-resources/**")
            .excludePathPatterns("/error")
            .excludePathPatterns("/webjars/**");
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
