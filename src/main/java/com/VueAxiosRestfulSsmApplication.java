package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.tentact.mapper")
public class VueAxiosRestfulSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueAxiosRestfulSsmApplication.class, args);
    }

}
