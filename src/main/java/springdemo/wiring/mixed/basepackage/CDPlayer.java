package springdemo.wiring.mixed.basepackage;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
