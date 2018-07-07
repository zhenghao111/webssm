package springdemo.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import springdemo.springmvc.domain.Spitter;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(new String[]{"springdemo.springmvc.domain"});
//        sessionFactoryBean.setAnnotatedClasses(new Class<?>[] {Spitter.class});

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }
}
