package com.zhenghao.aop.aop1;

import org.springframework.stereotype.Component;

@Component("music")
public class MusicPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("music perform");
    }
}
