package com.zhenghao.aop.aop5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean("musicPerformance")
    public MusicPerformance musicPerformance() {
        return new MusicPerformance();
    }

    @Bean
    public DefaultEncoreable encoreable() {
        return new DefaultEncoreable();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return  new EncoreableIntroducer();
    }
}
