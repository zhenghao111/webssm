package com.zhenghao.wiring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zhenghao.wiring.javaconfig.basepackage.CDPlayer;
import com.zhenghao.wiring.javaconfig.basepackage.ICD;
import com.zhenghao.wiring.javaconfig.basepackage.IMediaPlayer;
import com.zhenghao.wiring.javaconfig.basepackage.SgtPeppers;

@Configuration
public class CDPlayerConfig {

    @Bean(name = "SgtPeppers")
    public ICD sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean(name = "cdPlayer")
    public IMediaPlayer cdPlayer() {
        //Spring会拦截对sgtPeppers()的调用，然后返回bean
        return new CDPlayer(sgtPeppers());
    }

    //Spring自动装配需要的bean到参数中，推荐这种
    @Bean(name = "cdPlayer2")
    public IMediaPlayer cdPlyer2(ICD cd) {
        return new CDPlayer(cd);//构造器注入
    }

    //上面是通过构造器方法DI，通过其他方法DI
    @Bean(name = "cdPlayer3")
    public IMediaPlayer cdPlayer3(ICD cd) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(cd);
        return cdPlayer;
    }



}
