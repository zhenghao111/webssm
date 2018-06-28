package springdemo.wiring.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springdemo.wiring.qualifier.customqualifier.Cold;
import springdemo.wiring.qualifier.customqualifier.Creamy;
import springdemo.wiring.qualifier.customqualifier.Fruity;

@Component
//Java不允许添加多个相同的注解，用自定义的限定符注解
//@Qualifier("cold")
//@Qualifier("fruity")
@Cold
@Fruity
public class Popsicle implements Dessert {

}
