package com.zhenghao.aop.aop2;

import java.util.List;

public class BlankDisc implements CD {

    private String title;
    private String artist;
    private List<Integer> tracks;

    public BlankDisc() {
    }

    public BlankDisc(String title, String artist, List<Integer> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        for (Integer track : tracks) {
            playTrack(track);
        }

    }

    @Override
    public void playTrack(Integer trackNumber) {
        System.out.println("Track: " + trackNumber);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<Integer> tracks) {
        this.tracks = tracks;
    }
}
