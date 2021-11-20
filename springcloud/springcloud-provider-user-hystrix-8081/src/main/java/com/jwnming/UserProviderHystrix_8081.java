package com.jwnming;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 蒋文明
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // 微服务注册到注册中心
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // 添加熔断机制支持
public class UserProviderHystrix_8081 {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(UserProviderHystrix_8081.class, args);
    }


    /**
     * 增加hystrix监控
     * @return
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;
    }

}
