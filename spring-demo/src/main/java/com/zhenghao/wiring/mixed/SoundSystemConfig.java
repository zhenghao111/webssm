package com.zhenghao.wiring.mixed;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
// 在根JavaConfig中管理JavaConfig和Xml
@Import(CDPlayerConfig.class)
@ImportResource("classpath:springdemo/com.zhenghao.wiring/mixed/blankDisc.xml")
public class SoundSystemConfig {
}


