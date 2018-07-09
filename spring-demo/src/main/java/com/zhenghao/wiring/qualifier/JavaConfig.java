package com.zhenghao.wiring.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JavaConfig {


    @Bean
    @Primary //在显示配置JavaConfig中配置首选项
    @Qualifier("cold") //在JavaConfig中指定限定符
    public Dessert iceCream() {
        return new IceCream();
    }
}
