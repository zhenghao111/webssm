package springdemo.wiring.xml.basepackage;

import lombok.Setter;

import java.util.List;

public class BlankDiscWithTracks implements ICD {

    @Setter
    private String title;
    @Setter
    private String artist;
    @Setter
    private List<String> tracks;

    public BlankDiscWithTracks(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
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

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for(String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}
