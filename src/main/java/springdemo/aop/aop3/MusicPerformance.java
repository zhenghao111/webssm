package springdemo.aop.aop3;

import org.springframework.stereotype.Component;

public class MusicPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("music perform");
    }
}
