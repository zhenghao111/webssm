package com.zhenghao.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;


@Configuration
@EnableWebMvc //启用Spring MVC
@ComponentScan("com.zhenghao")
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    // 查找JSP文件，处理视图JSP
    @Bean
    public ViewResolver viewResolver() {
        //视图解析器
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        //使用JSTL来处理格式化和信息
//        resolver.setViewClass(org.springframework.web.servlet.com.zhenghao.view.JstlView.class);
        return resolver;
    }

    // 静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
    }

    // 定义TilesConfigurer定位和加载Tiles定义
//    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        //定位和加载Tiles定义
        tiles.setDefinitions(new String[] {
                "/WEB-INF/layout/tiles.xml"
        });
        //启用刷新功能
        tiles.setCheckRefresh(true);
        return tiles;
    }

    //Tiles视图解析器
//    @Bean
    public TilesViewResolver viewResolver2() {
        // 把逻辑视图名解析为Tiles定义
        return new TilesViewResolver();
    }

    //Thymeleaf视图解析器.把逻辑视图名解析为Thymeleaf模板视图
//    @Bean
    public ViewResolver viewResolver3(TemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // 模板引擎，处理模板、渲染结果
//    @Bean
    public TemplateEngine templateEngine(AbstractConfigurableTemplateResolver templateResolution) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolution);
        return engine;
    }

    private ApplicationContext applicationContext;

    // 模板解析器，定位和加载Thymeleaf模板
//    @Bean
    public AbstractConfigurableTemplateResolver templateResolution() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 配置multipart解析器
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }


}
