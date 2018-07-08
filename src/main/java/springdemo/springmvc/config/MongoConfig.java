package springdemo.springmvc.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//方法1
//@Configuration
////启用Spring Data MongoDB
//@EnableMongoRepositories(basePackages = "springdemo.springmvc.repository.springdata.mongodb")
//public class MongoConfig {
//
//    @Bean
//    public MongoClientFactoryBean mongoClientFactoryBean() {
//        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//        mongo.setHost("node");
//        return mongo;
//    }
//
//    @Bean
//    public MongoOperations mongoTemplate(MongoClient mongoClient) {
//        return new MongoTemplate(mongoClient, "OrdersDB");
//    }
//}

//方法2
@Configuration
//启用Spring Data MongoDB
@EnableMongoRepositories(basePackages = "springdemo.springmvc.repository.springdata.mongodb")
public class MongoConfig extends AbstractMongoConfiguration {


    @Override
    public MongoClient mongoClient() {
        return new MongoClient("node");
    }

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }
}