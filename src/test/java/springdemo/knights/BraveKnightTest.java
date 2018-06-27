package springdemo.knights;

import org.junit.Test;
import springdemo.knights.BraveKnight;
import springdemo.knights.Quest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        // mock框架Mockito
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
