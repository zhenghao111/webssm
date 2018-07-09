package com.zhenghao.aop.aop2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean("blankDisc")
    public CD blankDisc() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Custom title");
        cd.setArtist("Custom artist");
        List<Integer> tracks = new ArrayList<>();
        tracks.add(1);
        tracks.add(2);
        tracks.add(3);
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
