package com.enlink.redisdic.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan({"com.enlink.redisdic.backend","com.enlink.redisdic.dao"})
@MapperScan("com.enlink.redisdic.dao.mapper*")
@ImportResource(locations = { "classpath:generator_web_db.xml" })
//@Controller
@SpringBootApplication
public class RedisDicBackendApp {
//    @RequestMapping
//    public String index(){
//        return "/index";
//    }
    public static void main(String[] args) {
        SpringApplication.run(RedisDicBackendApp.class,args);
    }
}
