package springdemo.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc //启用Spring MVC
@ComponentScan("springdemo.springmvc")
public class WebConfig extends WebMvcConfigurerAdapter {



    // 查找JSP文件，处理视图JSP
//    @Bean
    public ViewResolver viewResolver() {
        //视图解析器
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        //使用JSTL来处理格式化和信息
//        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        return resolver;
    }

    // 静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
    }

    // 定义TilesConfigurer
    @Bean
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

    @Bean
    public TilesViewResolver viewResolver2() {
        // 把逻辑视图名解析为Tiles定义
        return new TilesViewResolver();
    }

}
