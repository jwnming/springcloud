package com.jwnming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 蒋文明
 * Eureka注册中心启动类
 */
@SpringBootApplication
@EnableEurekaServer // 接收客户端注册
public class EurekaServer_8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_8001.class, args);
    }
}
