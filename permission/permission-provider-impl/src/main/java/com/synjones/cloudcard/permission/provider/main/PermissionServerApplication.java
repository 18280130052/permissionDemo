package com.synjones.cloudcard.permission.provider.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value="com.synjones.cloudcard.permission")
@MapperScan("com.synjones.cloudcard.permission.infra.dao")
@SpringBootApplication
public class PermissionServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PermissionServerApplication.class, args);
    }
}
