package com.zhenghao.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.*;

// 方式0 通过web.xml配置DispatcherServlet、ContextLoaderListener
// 指定JavaConfig(配AnnotationConfigWebApplicationContext)或者spring-context.xml
// 配置servlet-mapping

// 方式1 继承AbstractAnnotationConfigDispatcherServletInitializer或者DispatcherServletInitializer
// 自动创建DispatcherServlet、ContextLoaderListener加载Spring上下文、其他Spring上下文
// 重写getRootConfigClasses、getServletConfigClasses、getServletMappings方法
// servlet映射是将URL请求由DispatcherServlet处理
// 重写customizeRegistration(ServletRegistration.Dynamic servlet)进行扩展

// 方式2 实现WebApplicationInitializer，在onStartup(ServletContext servletContext)中配置DispatcherServlet
// 用AnnotationConfigWebApplicationContext或者ClassPathXmlApplicationContext创建Sping Context
// context.register(JavaConfig或者xml)，，创建Bean
// context.setServletContext(servletContext),Spring Context与Servlet Context容器
// ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context)); 创建DispatcherServlet
// servlet.addMapping(new String[]{"/", "/homepage"});


// URL请求 -> DispatcherServlet/前端控制器 -> 处理器映射 -> 控制器 -逻辑视图名-> 视图解析器 -视图-> 客户端
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootConfig.class,
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class
        };
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{MyFilter.class};
//    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/",  "/spittle" };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        super.customizeRegistration(registration);
        // 对multipart的支持
        registration.setMultipartConfig(
                new MultipartConfigElement("/Users/zhenghao/Documents/Workspace/IDEA/webssm/uploads", 511374, 611374, 0)
        );
        //设置load-on-start的优先级
//        registration.setLoadOnStartup(1);
        //设置初始化参数
//        registration.setInitParameter();
    }
}

// 方式2
//public class SpittrWebAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        // spring上下文
//        AnnotationConfigWebApplicationContext context =
//                new AnnotationConfigWebApplicationContext();
//        // 注册JavaConfig
//        context.register(WebConfig.class);
//        //
//        context.setServletContext(servletContext);
//
//        // 手动注册自己的Servlet,DispatcherServlet
//        ServletRegistration.Dynamic servlet =
//                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//        servlet.addMapping(new String[]{"/", "/homepage"});
//
//        // 手动注册自己的Filter
////        FilterRegistration filter = servletContext.addFilter("", MyFilter);
////        filter.addMappingForUrlPatterns(null, false, "/custom/*");
//
//        // 设置load-on-startup优先级
//        servlet.setLoadOnStartup(1);
//    }
//}