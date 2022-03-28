package com.sanxia.exception;

import com.sanxia.result.Result;
import com.sanxia.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice 配合 @ExceptionHandler 实现全局异常处理
 * User: 冯寒斌
 * Date: 2021/12/2
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Result handleAuthorizationException(UnauthorizedException e) {
        String message = "权限认证失败!";
        return ResultFactory.buildFailResult(message);
    }
}
