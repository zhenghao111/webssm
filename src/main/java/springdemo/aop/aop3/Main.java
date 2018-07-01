package springdemo.aop.aop3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aop3.xml");
        Performance performance = (Performance) context.getBean("musicPerformance");
        performance.perform();

    }
}
