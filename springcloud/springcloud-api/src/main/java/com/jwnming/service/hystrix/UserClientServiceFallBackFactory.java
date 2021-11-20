package com.jwnming.service.hystrix;

import com.jwnming.entity.ResultMessage;
import com.jwnming.service.UserClientService;
import com.jwnming.utils.ResultUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author 蒋文明
 * 服务调用失败回调工厂,作Hystrix服务降级
 */
@Component
public class UserClientServiceFallBackFactory implements FallbackFactory {

    public UserClientService create(Throwable throwable) {
        return new UserClientService() {

            public ResultMessage queryById(Integer id) {
                return ResultUtil.fail("根据id[" + id + "]查询用户失败！该微服务维护中，服务降级处理！");
            }

            public ResultMessage queryAllUser() {
                return  ResultUtil.fail("查询所有用户失败，该微服务维护中，服务降级处理！");
            }
        };
    }
}
