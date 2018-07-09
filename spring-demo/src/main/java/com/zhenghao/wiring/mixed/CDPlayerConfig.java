package com.zhenghao.wiring.mixed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.zhenghao.wiring.mixed.basepackage.CDPlayer;
import com.zhenghao.wiring.mixed.basepackage.ICD;
import com.zhenghao.wiring.mixed.basepackage.IMediaPlayer;


@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public IMediaPlayer cdPlayer(ICD cd) {
        return new CDPlayer(cd);
    }
}
