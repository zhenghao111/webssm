package com.zhenghao.wiring.javaconfig.basepackage;

import lombok.Setter;

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
