package com.nxd.ftt.config.exception;

import com.nxd.ftt.entity.result.Response;
import com.nxd.ftt.entity.result.ResultKit;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常统一处理
 *
 * @author luhangqi
 * @date 2018/10/31
 */
@ControllerAdvice
public class ExceptionUnityHandle {


    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Response handleUnauthorizedException(UnauthorizedException e) {
        e.printStackTrace();
        return ResultKit.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(Exception e) {
        e.printStackTrace();
//        ModelAndView mv = new ModelAndView("view/error");
//        mv.addObject(ResultKit.error());
        return ResultKit.error(e.getMessage());
    }
}
