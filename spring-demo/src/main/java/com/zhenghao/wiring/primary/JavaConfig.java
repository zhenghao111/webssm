package com.zhenghao.wiring.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JavaConfig {


    @Bean
    @Primary //在显示配置JavaConfig中配置首选项
    public Dessert iceCream() {
        return new IceCream();
    }
}
