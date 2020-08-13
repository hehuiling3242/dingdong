package com.dingdong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.dingdong.*"
})
@MapperScan("com.dingdong.mapper")
public class DingdongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingdongApplication.class, args);
    }

}
