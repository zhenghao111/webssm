package com.zhenghao.jms.alerts;

import com.zhenghao.domain.Spittle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class ReceiveTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("activemq.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        AlertService alertService = new AlertServiceImp(jmsTemplate);
        // 接收是同步的，如果一直没有收到就会阻塞
        Spittle spittle = alertService.receiveSpittleAlert();
        System.out.println(spittle.getId());
    }
}
