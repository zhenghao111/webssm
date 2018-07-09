package com.zhenghao.aop.aop1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
// 启用自动代理 xml中<com.zhenghao.aop:aspectj-autoproxy />
@EnableAspectJAutoProxy
public class ConcertConfig {

    // 用@Component
//    @Bean
//    public Audience audience() {
//        return new Audience();
//    }
}
