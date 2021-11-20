package com.jwnming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import com.ribbon.MyRibbonConfig;

/**
 * @author 蒋文明
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient

// 工程启动时，去加载自定义Ribbon相关配置, 注意name属性，大小写敏感
@RibbonClient(name = "springcloud-provider-user", configuration = MyRibbonConfig.class)
public class UserConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumer_80.class, args);
    }


}
