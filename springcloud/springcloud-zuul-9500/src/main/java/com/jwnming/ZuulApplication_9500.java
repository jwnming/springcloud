package com.jwnming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 代理
public class ZuulApplication_9500 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9500.class, args);
    }
}
