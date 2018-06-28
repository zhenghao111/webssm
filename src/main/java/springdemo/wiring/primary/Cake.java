package springdemo.wiring.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //自动配置中添加首选项
public class Cake implements Dessert{
}
