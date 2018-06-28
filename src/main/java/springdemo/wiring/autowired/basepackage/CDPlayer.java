package springdemo.wiring.autowired.basepackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cdPlayer")
public class CDPlayer implements IMediaPlayer{
    private ICD cd;

    //自动装配，自动注入
    //required = false，没有匹配，未装配状态，可能出现NullPointerException
    @Autowired(required = false)
    public CDPlayer(ICD cd) {
        this.cd = cd;
    }

    @Autowired
    public void setCd(ICD cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
