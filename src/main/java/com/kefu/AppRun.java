package com.kefu;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com/kefu/mapper")
@Slf4j
public class AppRun {

    public static void main(String[] args) {
        log.info("客服聊天系统后台已启动");
        SpringApplication.run(AppRun.class, args);
    }
}
