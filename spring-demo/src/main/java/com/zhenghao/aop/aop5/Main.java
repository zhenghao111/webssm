package com.zhenghao.aop.aop5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Encoreable performance = (Encoreable) context.getBean("musicPerformance");
        performance.performEncoreable();

    }
}
