package springdemo.aop.aop2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TrackCounterConfig.class);
        BlankDisc cd = (BlankDisc) context.getBean("blankDisc");
        cd.playTrack(1);
    }
}
