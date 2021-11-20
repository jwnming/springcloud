package com.jwnming.utils;

import com.jwnming.common.ResultEnum;
import com.jwnming.entity.ResultMessage;

/**
 * @author 蒋文明
 * 返回信息统一处理类
 */
public class ResultUtil {

    public static ResultMessage success(Object data) {
        ResultMessage resultMessage = new ResultMessage(ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getMsg(), data);
        return resultMessage;
    }

    public static ResultMessage fail() {
        ResultMessage resultMessage = new ResultMessage(ResultEnum.FAIL.getCode(),
                ResultEnum.FAIL.getMsg(), null);
        return resultMessage;
    }

    public static ResultMessage fail(String failMsg) {
        ResultMessage resultMessage = new ResultMessage(ResultEnum.FAIL.getCode(),
                failMsg, null);
        return resultMessage;
    }
}