package com.buba.monthtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@MapperScan("com.buba.monthtest.dao")
@SpringBootApplication
@EnableScheduling
public class MonthtestApplication {

    public static void main(String[] args) {
       SpringApplication.run(MonthtestApplication.class, args);
    }

}
