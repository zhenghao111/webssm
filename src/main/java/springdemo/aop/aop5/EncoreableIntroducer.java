package springdemo.aop.aop5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "springdemo.aop.aop5.Performance+",
    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
