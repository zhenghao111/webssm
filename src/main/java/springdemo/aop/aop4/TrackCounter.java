package springdemo.aop.aop4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {

    private Map<Integer, Integer> trackCounter =
            new HashMap<Integer, Integer>();


    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounter.put(trackNumber, currentCount+1);
        System.out.println(currentCount+1);
    }

    private int getPlayCount(int trackNumber) {
        return trackCounter.containsKey(trackNumber) ? trackCounter.get(trackNumber) : 0;
    }

    public int getPlayCounter(int trackNumber) {
        return trackCounter.get(trackNumber);
    }
}
