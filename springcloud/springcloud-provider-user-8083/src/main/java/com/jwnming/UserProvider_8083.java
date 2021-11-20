package com.jwnming;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 蒋文明
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // 微服务注册到注册中心
@EnableDiscoveryClient // 服务发现
public class UserProvider_8083 {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(UserProvider_8083.class, args);
    }




}
