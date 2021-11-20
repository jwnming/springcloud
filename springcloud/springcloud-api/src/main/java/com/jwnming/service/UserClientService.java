package com.jwnming.service;

import com.jwnming.entity.ResultMessage;
import com.jwnming.service.hystrix.UserClientServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 蒋文明
 * Feign客户端
 */
@Component

// feign远程调用、fallback服务降级
@FeignClient(value = "SPRINGCLOUD-PROVIDER-USER", fallbackFactory = UserClientServiceFallBackFactory.class)
public interface UserClientService {

    @RequestMapping("/user/getUserById/{id}")
    ResultMessage queryById(@PathVariable("id") Integer id);

    @RequestMapping("/user/getAllUser")
    ResultMessage queryAllUser();
}
