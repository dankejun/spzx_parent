package com.atguigu.spzx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Time: 2025/8/18
 * Author: Dankejun
 * Description:
 */
@SpringBootApplication
// @ComponentScan(basePackages = {"com.atguigu.spzx"})
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
