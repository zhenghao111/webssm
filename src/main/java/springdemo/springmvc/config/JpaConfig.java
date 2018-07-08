package springdemo.springmvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import springdemo.springmvc.domain.Spitter;

import javax.sql.DataSource;

@Configuration
//使用Spring Data JPA
//@EnableJpaRepositories(basePackages = "springdemo.springmvc.repository.springdata.jpa")
public class JpaConfig {

    //厂商适配器，指明使用哪一个厂商的JPA实现，TODO 这里应该有点问题
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return adapter;
    }

    //容器管理类型的实体管理器工厂，实体管理器由容器创建和管理，程序不和工厂打交道，实体管理器通过注入EntityManagerFactory或JNDI获取
    //应用程序类型的实体管理器工厂，实体管理器由程序创建和管理，程序向工厂请求实体管理器，工厂就创建一个实体管理器
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(adapter);
        //识别实体类，不需要在persistence.xml中进行声明了
        entityManagerFactoryBean.setPackagesToScan(new String[]{"springdemo.springmvc.domain"});


        return entityManagerFactoryBean;
    }


}
