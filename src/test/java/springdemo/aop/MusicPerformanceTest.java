package springdemo.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springdemo.aop.aop1.ConcertConfig;
import springdemo.aop.aop1.Performance;

@RunWith(SpringJUnit4ClassRunner.class) // 启动spring上下文
@ContextConfiguration(classes = ConcertConfig.class) //加载配置类，创建bean
public class MusicPerformanceTest {

    @Autowired //自动装配musicPerformance bean装入
            Performance performance;

    @Test
    public void performance() {
        performance.perform();
    }


}
