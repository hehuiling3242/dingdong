package com.dingdong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.dingdong"
})
public class DingdongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingdongApplication.class, args);
    }

}
