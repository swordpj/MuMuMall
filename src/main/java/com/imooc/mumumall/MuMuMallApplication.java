package com.imooc.mumumall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mumumall.model.dao")
public class MuMuMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuMuMallApplication.class, args);
    }

}
