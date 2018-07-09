package com.zhenghao.wiring.autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//默认是配置类所在的包作为基础包
//@ComponentScan
//指定基础包，String数组，类型不安全
//@ComponentScan(basePackages = {"springdemo.com.zhenghao.knights", "springdemo.com.zhenghao.wiring"})
//指定基础包，类所在的包下面全扫描，可以创建一个空标记接口，重构友好
@ComponentScan(basePackageClasses = IScan.class)
public class CDPlayerConfig {
}
