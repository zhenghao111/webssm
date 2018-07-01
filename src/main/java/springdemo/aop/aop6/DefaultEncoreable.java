package springdemo.aop.aop6;

public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncoreable() {
        System.out.println("DefaultEncoreable.performEncoreable()");
    }
}
