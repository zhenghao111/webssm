package com.zhenghao.knights;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        // mock框架Mockito
        // 模拟一个接口实现
        Quest mockQuest = mock(Quest.class);

        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
