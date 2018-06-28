package springdemo.wiring.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //自动配置中添加首选项
@Qualifier("cake") //在自动配置中指定限定符，不指定名字就是id
public class Cake implements Dessert {
}
