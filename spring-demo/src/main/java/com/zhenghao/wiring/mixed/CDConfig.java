package com.zhenghao.wiring.mixed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zhenghao.wiring.mixed.basepackage.ICD;
import com.zhenghao.wiring.mixed.basepackage.SgtPeppers;

@Configuration
public class CDConfig {

    @Bean
    public ICD sgtPeppers() {
        return new SgtPeppers();
    }
}
