package springdemo.aop.aop5;

public class MusicPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("music perform");
    }
}
