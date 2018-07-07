package springdemo.springmvc.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.*;

// 方式1 自动创建DispatcherServlet、ContextLoaderListener加载Spring上下文、其他Spring上下文
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
        return new String[]{ "/", "/homepage", "/spittle" };
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