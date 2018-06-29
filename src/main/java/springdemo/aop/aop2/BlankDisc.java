package springdemo.aop.aop2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

public class BlankDisc implements CD {

    @Setter
    private String title;
    @Setter
    private String artist;
    @Setter
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

}
