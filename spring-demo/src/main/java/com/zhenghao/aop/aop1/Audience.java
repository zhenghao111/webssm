package com.zhenghao.aop.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 定义一个切面=通知（做什么、何时）+切点（何处）
@Aspect
@Component
public class Audience {

    //定义一个可重用的切点
    @Pointcut("execution(* com.zhenghao.aop.aop1.Performance.perform(..))")
    public void performance(){}

    //@AspectJ注解标注切点,通知=Before（何时）+方法（什么），表达式是切点表达式（何处）
    //表演前
    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("Silencing call phones");
    }

    //表演前
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    //表演后
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    //表演失败后
    @AfterThrowing("performance()")
    public void demanRefund() {
        System.out.println("Demandinga refund");
    }


    //环绕通知
    @Around("performance()")
    public void watcherformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing call phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP");
        } catch (Throwable e) {
            System.out.println("Demandinga refund");
        }


    }


}
