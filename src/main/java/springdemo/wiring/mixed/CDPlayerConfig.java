package springdemo.wiring.mixed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import springdemo.wiring.mixed.basepackage.BlankDisc;
import springdemo.wiring.mixed.basepackage.CDPlayer;
import springdemo.wiring.mixed.basepackage.ICD;
import springdemo.wiring.mixed.basepackage.IMediaPlayer;

@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public IMediaPlayer cdPlayer(ICD cd) {
        return new CDPlayer(cd);
    }
}
