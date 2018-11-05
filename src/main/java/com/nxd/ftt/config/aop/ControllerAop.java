package com.nxd.ftt.config.aop;

import com.google.gson.Gson;
import com.nxd.ftt.config.annotation.LogAndPermission;
import com.nxd.ftt.config.exception.NoPermissionException;
import com.nxd.ftt.util.Const;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 控制层AOP
 *
 * @author luhangqi
 * @date 2018/10/31
 */
@Component
@Aspect
public class ControllerAop {

    @Pointcut("execution(* com.nxd.ftt.controller..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws NoPermissionException {
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        Method method = joinPointObject.getMethod();
        LogAndPermission methodAnnotation = method.getAnnotation(LogAndPermission.class);

        if (methodAnnotation != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //记录日志
            Class<?> aClass = joinPoint.getTarget().getClass();
            if (aClass != null) {
                RequestMapping classAnnotation = aClass.getAnnotation(RequestMapping.class);
                classAnnotation.value();
            }
            if (methodAnnotation.permissions() != null && methodAnnotation.permissions().length > 0) {
                //校验权限
                List<String> perms = Arrays.asList(methodAnnotation.permissions());
                List<String> per = new ArrayList<>();
                per.add("permission.save");
                request.getSession().setAttribute(Const.USER_ALL_PERMISSION, per);
                List<String> permissionList = (List<String>) request.getSession().getAttribute(Const.USER_ALL_PERMISSION);
                if (permissionList == null || !permissionList.containsAll(perms)) {
                    throw new NoPermissionException("缺少权限：" + new Gson().toJson(perms));
                }
            }
        }

        System.out.println("AOP Before Advice...");
    }

    //    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOP After Advice...");
    }

    //    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    //    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("AOP Aronud before...");
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Aronud after...");
    }
}
