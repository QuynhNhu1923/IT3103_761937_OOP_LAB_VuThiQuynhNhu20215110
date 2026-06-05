package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() { super(); }
    
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track đã tồn tại trong CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Không tìm thấy Track.");
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch(PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
    
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - Artist: " + artist + " - Length: " + getLength() + " - " + getCost() + "$";
    }
}