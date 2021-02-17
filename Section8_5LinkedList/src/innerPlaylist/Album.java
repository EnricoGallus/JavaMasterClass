package innerPlaylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }

        songs.add(new Song(title, duration));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song == null) {
            return false;
        }

        for (Song value : playList) {
            if (value.getTitle().equals(song.getTitle())) {
                return true;
            }
        }

        playList.add(song);
        return true;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        if (trackNumber <= 0 || trackNumber > songs.size()) {
            // trackNumber was out of range
            return false;
        }

        Song song = songs.get(trackNumber - 1);

        for (Song value : playList) {
            if (value.getTitle().equals(song.getTitle())) {
                return true;
            }
        }

        playList.add(song);
        return true;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }
}
