package com.zhenghao.wiring.placeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.zhenghao.wiring.mixed.basepackage.BlankDisc;

@Configuration
@PropertySource("classpath:springdemo/com.zhenghao.wiring/placeholder/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;
    // getProperty("key", [Integer.class], "default value")
    // getRequiredProperty("key") 必须有定义
    // getPropertyAsClass("key", CD.class) 解析为类
    // getActiveProfiles()
    // getDefaultProfiles()
    // acceptProfiles(String... profiles) 支持给定的profiles返回true

    public BlankDisc disc() {
        return new BlankDisc(env.getProperty("disc.title"), env.getProperty("disc.artist"));
    }
}
