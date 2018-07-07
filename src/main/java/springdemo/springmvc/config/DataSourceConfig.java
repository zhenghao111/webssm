package springdemo.springmvc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import springdemo.springmvc.repository.JdbcSpitterRepository;
import springdemo.springmvc.repository.SpitterRepository;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //JNDI数据源
    @Bean
    @Profile("proc")
    public DataSource jndiDataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    //数据源连接池
    @Bean
    @Profile("qa")
    public BasicDataSource cpDataSource() {
        //dbcp
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://node:3306/db_ssm2");
        basicDataSource.setUsername("zhenghao");
        basicDataSource.setPassword("159753");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(10);
        return basicDataSource;
    }

    //JDBC驱动的数据源
    @Bean
    @Profile("dev1")
    public DataSource jdbcDataSource() {
        //SingleConnectionDataSource只有一个数据库连接，不适合多线程，测试可以用
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://node:3306/db_ssm2");
        driverManagerDataSource.setUsername("zhenghao");
        driverManagerDataSource.setPassword("159753");
        return driverManagerDataSource;
    }

    //嵌入式数据源
    @Bean
    @Profile("dev2")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("")
                .addScript("")
                .build();
    }





}
