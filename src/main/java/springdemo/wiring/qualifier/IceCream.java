package springdemo.wiring.qualifier;

import org.springframework.stereotype.Component;
import springdemo.wiring.qualifier.customqualifier.Cold;
import springdemo.wiring.qualifier.customqualifier.Creamy;

@Component
//自定义的限定符注解，可以添加多个
@Cold
@Creamy
public class IceCream implements Dessert {
}
