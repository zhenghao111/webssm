package com.zhenghao.wiring.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.zhenghao.wiring.mixed.basepackage.ICD;

@Component
public class BlankDisc implements ICD {

    private String title;
    private String artist;

    // 组件扫描和自动装配中使用#{}，运行时注入
    public BlankDisc(@Value("#{systemProperties['disc.title']}") String title,
                     @Value("#{systemProperties['disc.artist']}") String artist) {
        this.title = title;
        this.artist = artist;
    }


    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
