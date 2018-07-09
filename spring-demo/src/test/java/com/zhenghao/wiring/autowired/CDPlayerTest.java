package com.zhenghao.wiring.autowired;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zhenghao.wiring.autowired.basepackage.ICD;
import com.zhenghao.wiring.autowired.basepackage.IMediaPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class) //创建Spring应用上下文
@ContextConfiguration(classes = CDPlayerConfig.class) //说明需要在CDPlayerCOnfig中加载配置
public class CDPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private IMediaPlayer player;

    @Autowired
    private ICD cd;

    @Test
    public void cdSouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles",
                systemOutRule.getLog());
    }
}
