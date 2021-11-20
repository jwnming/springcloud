package com.jwnming.controller;


import com.jwnming.entity.User;
import com.jwnming.service.UserService;
import com.jwnming.entity.ResultMessage;
import com.jwnming.utils.ResultUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蒋文明
 * 提供 rest 服务
 */
@RestController
@RequestMapping("/hystrix/user")
public class UserHystrixController {

    @Autowired
    private UserService userService;



    @RequestMapping("/getUserById/{id}")
    @HystrixCommand(fallbackMethod = "getUserByIdHystrix") // 失败回调方法
    public ResultMessage getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);

        if (user == null) {
            // 制造异常
            throw new RuntimeException("id[" + id + "]对应用户不存在！");
        }
        return ResultUtil.success(user);
    }


    public ResultMessage getUserByIdHystrix(@PathVariable("id") Integer id) {
        return ResultUtil.fail("id[" + id + "]对应用户不存在！");
    }


}
