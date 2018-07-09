package com.zhenghao.aop.aop3;

import org.aspectj.lang.ProceedingJoinPoint;

// 定义一个切面=通知（做什么、何时）+切点（何处）

public class Audience {


    public void silenceCellPhone() {
        System.out.println("Silencing call phones");
    }

    public void takeSeats() {
        System.out.println("Taking seats");
    }

    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    public void demanRefund() {
        System.out.println("Demandinga refund");
    }

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
