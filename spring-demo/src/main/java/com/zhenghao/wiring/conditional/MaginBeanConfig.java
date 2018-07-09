package com.zhenghao.wiring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaginBeanConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MaginBean magicBean() {
        return new MaginBean();
    }
}
