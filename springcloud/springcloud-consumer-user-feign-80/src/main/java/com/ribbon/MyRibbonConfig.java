package com.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 蒋文明
 * 自定义Rinbbon配置类
 */
@Configuration
public class MyRibbonConfig {

    /*@Bean
    public IRule myRule() {
        return new RandomRule(); // 使用别人写好的规则：随机
    }*/

    @Bean
    public IRule getRule() {
        return new MyRibbonLB(); // 自定义负载均衡,默认时轮询策略
    }
}
