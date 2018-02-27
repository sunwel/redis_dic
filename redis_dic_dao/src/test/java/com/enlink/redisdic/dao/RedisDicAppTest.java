package com.enlink.redisdic.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@MapperScan("com.enlink.redisdic.dao.mapper*")
@ImportResource(locations = { "classpath:generator_web_db.xml" })
@SpringBootApplication
public class RedisDicAppTest {
    public static void main(String[] args) {
        SpringApplication.run(RedisDicAppTest.class,args);
    }
}
