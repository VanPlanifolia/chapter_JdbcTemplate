package com.MyAspect;

import com.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    //定义切入点表达式
    @Pointcut("execution(* com.dao.UserDao.*(..))")
    //创建空方法作为切入点
    private void myPointCut(){};
    //前置通知
    @Before("myPointCut()")
    public void myBefor(JoinPoint joinPoint){
        System.out.println("前置通知：模拟执行权限检查....");
        System.out.println("被植入增强处理的方法为："+joinPoint.getSignature().getName());
    }
    //后置通知
    @AfterReturning("myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知：");
        System.out.println("被植入增强处理的方法为："+joinPoint.getSignature().getName());
    }

}