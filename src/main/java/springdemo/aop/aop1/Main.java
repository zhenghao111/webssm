package springdemo.aop.aop1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance performance = (Performance) context.getBean("music");
        performance.perform();

    }
}
