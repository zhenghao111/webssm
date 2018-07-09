package com.zhenghao.aop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zhenghao.aop.aop2.CD;
import com.zhenghao.aop.aop2.TrackCounter;
import com.zhenghao.aop.aop2.TrackCounterConfig;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CD cd;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public  void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);

        assertEquals(2, trackCounter.getPlayCounter(1));
        assertEquals(1, trackCounter.getPlayCounter(2));
        assertEquals(1, trackCounter.getPlayCounter(3));

    }

}
