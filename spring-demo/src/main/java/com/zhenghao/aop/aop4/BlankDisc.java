package com.zhenghao.aop.aop4;

import java.util.List;

public class BlankDisc implements CD {

    private String title;
    private String artist;
    private List<String> tracks;


    @Override
    public void playTrack(String trackNumber) {
        System.out.println("Track: " + trackNumber);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
