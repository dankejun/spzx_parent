package com.atguigu.spzx.manager.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Time: 2025/6/24
 * Author: Dankejun
 * Description:
 */
@Component
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //添加路径规则
                .allowCredentials(true) //是否允许在跨域情况下传递Cookie
                .allowedOriginPatterns("*") //允许请求来源的域规则
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
