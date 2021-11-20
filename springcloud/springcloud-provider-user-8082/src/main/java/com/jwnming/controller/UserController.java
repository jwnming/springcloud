package com.jwnming.controller;


import com.jwnming.entity.User;
import com.jwnming.service.UserService;
import com.jwnming.entity.ResultMessage;
import com.jwnming.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蒋文明
 * 提供 rest 服务
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public ResultMessage addUser(User user) {
        return userService.addUser(user) ?
                ResultUtil.success(user) : ResultUtil.fail();
    }

    @RequestMapping("/getUserById/{id}")
    public ResultMessage getUserById(@PathVariable("id") Integer id) {
        return ResultUtil.success(userService.getUserById(id));
    }

    @GetMapping("/getAllUser")
    public ResultMessage getUserById() {
        return ResultUtil.success(userService.getAllUser());
    }




}
