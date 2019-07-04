package com.my.springbootintegratemybatis.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice

public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse<Object> response(Exception e) {
        CommonResponse<Object> response = new CommonResponse<Object>();
        response.setSuccess(false);
        if (e instanceof UnauthenticatedException) {
            response.setCode(401);
            response.setErrorMessage("用户未登录");
        }
        if (e instanceof UnauthorizedException) {
            response.setCode(403);
            response.setErrorMessage("暂无访问权限");
        } else {
            response.setCode(500);
            response.setErrorMessage("系统错误:" + e.getMessage());
        }
        return response;
    }
}
