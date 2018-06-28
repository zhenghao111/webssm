package springdemo.wiring.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springdemo.wiring.primary.Dessert;
import springdemo.wiring.primary.IceCream;

@Configuration
public class JavaConfig {


    @Bean
    @Primary //在显示配置JavaConfig中配置首选项
    @Qualifier("cold") //在JavaConfig中指定限定符
    public Dessert iceCream() {
        return new IceCream();
    }
}
