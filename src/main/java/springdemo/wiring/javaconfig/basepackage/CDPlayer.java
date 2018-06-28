package springdemo.wiring.javaconfig.basepackage;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CDPlayer implements IMediaPlayer {

    @Setter
    private ICD cd;

    public CDPlayer() {

    }

    public CDPlayer(ICD cd) {
        this.cd = cd;
    }



    @Override
    public void play() {
        cd.play();
    }
}
