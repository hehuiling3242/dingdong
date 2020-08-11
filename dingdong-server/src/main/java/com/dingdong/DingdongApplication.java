package com.dingdong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.dingdong.*"
})
public class DingdongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingdongApplication.class, args);
    }

}
