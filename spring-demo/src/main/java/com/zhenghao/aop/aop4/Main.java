package com.zhenghao.aop.aop4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aop4.xml");
        BlankDisc cd = (BlankDisc) context.getBean("blankDisc");
        cd.playTrack("1");
    }
}
