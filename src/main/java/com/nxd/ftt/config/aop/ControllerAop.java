package com.nxd.ftt.config.aop;

import com.nxd.ftt.config.annotation.LogAndPermission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

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
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        Method method = joinPointObject.getMethod();
        LogAndPermission methodAnnotation = method.getAnnotation(LogAndPermission.class);
        if (methodAnnotation != null) {
            methodAnnotation.value();
            String[] perms = methodAnnotation.permissions();
            Class<?> aClass = joinPoint.getTarget().getClass();
            if (aClass != null) {
                RequestMapping classAnnotation = aClass.getAnnotation(RequestMapping.class);
                classAnnotation.value();
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

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
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
