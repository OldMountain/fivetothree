package com.nxd.ftt.exception;

import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一处理
 *
 * @author luhangqi
 * @date 2018/10/31
 */
@ControllerAdvice
public class ExceptionUnityHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(Exception e){
        e.printStackTrace();
        return ResultKit.error();
    }
}