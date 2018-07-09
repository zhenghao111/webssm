package com.zhenghao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//启用缓存
@EnableCaching
public class CachingConfig {

    //声明缓存管理器
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

//    @Bean
//    public EhCacheCacheManager ehCacheCacheManager(net.sf.ehcache.CacheManager cm) {
//        return new EhCacheCacheManager(cm);
//    }
//
//    @Bean
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        ehCacheManagerFactoryBean.setConfigLocation(Resource);
//        return ehCacheManagerFactoryBean;
//    }


}
