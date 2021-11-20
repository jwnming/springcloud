package com.jwnming.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 蒋文明
 * bean工程配置
 */
@Configuration
public class ConfigBean {

    /**
     * @Bean注册 RestTemplate
     * @LoadBalanced 负载均衡
     *
     * @return
     */
    @Bean
    @LoadBalanced  // Ribbon （基于客户端负载均衡）
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    /*@Bean
    public IRule myRule() {
        return new RandomRule(); // 使用别人写好的规则：随机
    }*/

}
