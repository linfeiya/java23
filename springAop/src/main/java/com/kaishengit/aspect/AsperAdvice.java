package com.kaishengit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 通知类
 * Created by linfeiya on 2017/7/10 0010.
 */
@Component
@Aspect
public class AsperAdvice {
    @Pointcut("execution(* com.kaishengit.service..*.*(..))")
    public void poincut(){}

    @Before("poincut()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
    @AfterThrowing("poincut()")
    public void exceptionAdvice(){
        System.out.println("异常通知");
    }
    @AfterReturning("poincut()")
    public void afterAdvice(){
        System.out.println("后置通知");
    }
    @After("poincut()")
    public void finallyAdvice(){
        System.out.println("最终通知");
    }

    /*
        环绕通知
        注解的方式配置通知类
    * */
    //@Around("poincut()")
    public void accountAdvice(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("前置");
            proceedingJoinPoint.proceed();//代表目标对象的方法在此时被被执行
            System.out.println("后置");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常");
        } finally {
            System.out.println("最终");
        }
    }
}
