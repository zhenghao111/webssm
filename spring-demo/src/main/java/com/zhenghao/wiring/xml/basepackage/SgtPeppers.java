package com.zhenghao.wiring.xml.basepackage;

public class SgtPeppers implements ICD {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";


    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
