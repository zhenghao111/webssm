package com.zhenghao.wiring.mixed.basepackage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
public class BlankDisc implements ICD {

    private String title;
    private String artist;

    // 组件扫描和自动装配中使用${key} 占位符，运行时注入
    public BlankDisc(@Value("${disc.title") String title, @Value("artist") String artist) {
        this.title = title;
        this.artist = artist;
    }

    // 启用占位符
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
