package springdemo.wiring.mixed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdemo.wiring.mixed.basepackage.ICD;
import springdemo.wiring.mixed.basepackage.SgtPeppers;

@Configuration
public class CDConfig {

    @Bean
    public ICD sgtPeppers() {
        return new SgtPeppers();
    }
}
