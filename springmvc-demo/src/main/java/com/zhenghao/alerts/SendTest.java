package com.zhenghao.alerts;

import com.zhenghao.domain.Spittle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.util.Date;

public class SendTest {
    public static void main(String[] args) {

        Spittle spittle = new Spittle(123L, "message", new Date());

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("activemq.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        AlertService alertService = new AlertServiceImp(jmsTemplate);
        alertService.sendSpittleAlert(spittle);
    }
}
