package com.jwnming.controller;

import com.jwnming.entity.ResultMessage;
import com.jwnming.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 蒋文明
 * 获取微服务一些信息
 */
@RestController
@RequestMapping("/eureka")
public class EurekaClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getServices")
    public ResultMessage getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        return ResultUtil.success(services);
    }

    @RequestMapping("/getInstances")
    public ResultMessage getInstances() {
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-USER");
        return ResultUtil.success(instances);
    }
}
