package com.jwnming.controller;

import com.jwnming.entity.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 蒋文明
 * User消费者
 * 注意：消费则不应有提供者服务的处理
 *      url, 实体（map）, Class<T> responseType
 */
@RestController
@RequestMapping("/consumer/user")
public class UserConsumerRestController {

    @Autowired  // ConfigBean装配
    private RestTemplate restTemplate;


    private static final String REST_URL_PREFIX = "http://localhost:8081";

    @GetMapping("/getUserById/{id}")
    public ResultMessage getUserById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/getUserById/" + id, ResultMessage.class);
    }

    @GetMapping("/getAllUser")
    public ResultMessage getAllUser() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/getAllUser/", ResultMessage.class);
    }

}
