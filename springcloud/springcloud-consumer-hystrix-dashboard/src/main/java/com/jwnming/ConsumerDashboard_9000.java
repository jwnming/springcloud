package com.jwnming;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 蒋文明
 * hystrix dashboard 启动类
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启监控页面
public class ConsumerDashboard_9000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerDashboard_9000.class, args);
    }

}
