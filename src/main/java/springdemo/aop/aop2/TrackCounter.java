package springdemo.aop.aop2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import springdemo.wiring.conditional.MaginBean;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounter =
            new HashMap<Integer, Integer>();

    @Pointcut("execution(* springdemo.aop.aop2.BlankDisc.playTrack(int))   " +
                "&& args(trackNumber)")
    public void trackPlayer(int trackNumber) {}

    @Before("trackPlayer(trackNumber)")
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
