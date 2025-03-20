package com.halcyon.codeojbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.halcyon.codeojbackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class CodeOjBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeOjBackendApplication.class, args);
    }

}
