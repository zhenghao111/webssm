package com.zhenghao.jms.alerts;

import com.zhenghao.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;

public class AlertServiceImp implements AlertService {

    JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImp(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendSpittleAlert(Spittle spittle) {
//        jmsOperations.send("spittle.queue",
//                new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(spittle);
//            }
//        });

        // JmsTemplate指定了一个默认的目的地
        //匿名内部类只有一个方法可以使用Lambda
//        jmsOperations.send((Session session) -> {return session.createObjectMessage(spittle);} );

        // 使用消息转换器更加简单 MessageConverter实现类将 对象 转化为 Message
        // MappingJacksonMessageCOnverter 消息与JSON格式转换
        // MappingJackson2MessageConverter 消息与JSON格式转换
        // MarshallingMessageConverter 消息与XML格式转换
        // SimpleMessageConverter String与TextMessage，字节数组与BytesMessage，Map与MapMessage，Serializable对象与ObjectMessage
        // SimpleMessageConverter是默认的，可以通过声明消息转换器bean，注入到JmsTemplate的messageConverter中
        jmsOperations.convertAndSend(spittle);

    }

    @Override
    public Spittle receiveSpittleAlert() {
        // 接收是同步的，接收不到消息就会一直阻塞等待
//        ObjectMessage receiveMessage = (ObjectMessage) jmsOperations.receive();
//        try {
//            return (Spittle) receiveMessage.getObject();
//        } catch (JMSException e) {
//            throw JmsUtils.convertJmsAccessException(e);
//        }
//        System.out.println(jmsOperations.receiveAndConvert());
        return (Spittle) jmsOperations.receiveAndConvert();
    }




}
