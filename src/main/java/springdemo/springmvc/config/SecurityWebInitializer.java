package springdemo.springmvc.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
    //自动注册DelegatingFilterProxy
    //appendFileters、insertFileters可以注册自己的Filter
    //DelegatingFileterProxy拦截请求，委托给ID为springSecurityFilterChain bean
    //springSecurityFilterChain可以链接多个Filter



}
