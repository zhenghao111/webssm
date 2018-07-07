package springdemo.springmvc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import springdemo.springmvc.Spitter;
import springdemo.springmvc.config.DataSourceConfig;


@RunWith(SpringJUnit4ClassRunner.class) // 启动spring上下文
@ContextConfiguration(classes = DataSourceConfig.class) //加载配置类，创建bean
@ActiveProfiles("qa") //集成测试类中启用指定的Profile
public class JdbcSpitterRepository {

    @Autowired
    SpitterRepository spitterRepository;

    @Test
    public void addSpitterTest() {

        Spitter spitter = new Spitter("zheng", "hao", "zhenghao", "123456");
        spitterRepository.addSpitter(spitter);

    }
}
