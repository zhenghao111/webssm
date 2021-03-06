package com.zhenghao.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
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
    public ViewResolver internalResourceViewResolver() {
        //视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        //使用JSTL来处理格式化和信息
//        resolver.setViewClass(org.springframework.web.servlet.com.zhenghao.view.JstlView.class);
        return resolver;
    }

    // 内容协商视图解析器
    // 确定请求的媒体类型：1. URL的文件扩展名 2. Accept头部信息的MIME类型  3. /作为默认的媒体类型
    // 确定媒体类型，解析逻辑视图名，不会解析视图，委托给其他视图解析器
    // 其他视图解析器解析视图，添加到列表，
    // ContentNegotiationManager注入ContentNegotiatingViewResolver的contentNegotiationManager属性
//    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager cnm) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(cnm);
        return resolver;
    }

    // ContentNegotiationManager修改确定媒体类型的策略，ContentNegotiatingViewResolver也有对应的修改方法已被弃用
    // 指定默认的媒体类型、通过请求参数指定内容类型、忽略Accept头部信息、将请求的扩展名映射为特定的媒体类型、将JAF作为根据扩展名查找媒体类型的备用方案
    // 配置ContentNegotiationManager方式，
    // 方法1：直接声明ContentNegotiationManager类型的bean（复杂不推荐）
    // 方法2：通过ContentNegotiationManagerFactoryBean间接创建bean（XML方式）
    // 方法3：重载WebMvcConfigurerAdapter的configureContentNegotiation()（JavaConfig方式）
    // 限制：只能决定资源如何渲染到客户端，不能涉及客户端要发送什么样的表述给控制器；视图渲染模型给客户端，不是资源
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.defaultContentType(MediaType.TEXT_HTML);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
        // 会有ContentNegotiationManager bean，修改行为
        // ContentNegotiationConfigurer的方法对应了ContentNegotiationManager的setter方法
        // 可以用ContentNegotiationConfigurer 或者 ContentNegotiationManager 修改行为
    }

    // 以bean的形式查找视图，逻辑视图名是spittles，BeanNameViewResolver会解析spittles()中的View
//    @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    // 将spittles bean定义为JSON视图，逻辑视图名匹配bean名
    // 需要添加Jackson包
//    @Bean
    public View spittles() {
        return new MappingJackson2JsonView();
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
