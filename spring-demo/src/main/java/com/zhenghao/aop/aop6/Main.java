package com.zhenghao.aop.aop6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aop6.xml");
        Encoreable performance = (Encoreable) context.getBean("musicPerformance");
        performance.performEncoreable();

        ClassPathXmlApplicationContext context2 =
                new ClassPathXmlApplicationContext("aop7.xml");
        Encoreable performance2 = (Encoreable) context2.getBean("musicPerformance");
        performance2.performEncoreable();

    }
}
