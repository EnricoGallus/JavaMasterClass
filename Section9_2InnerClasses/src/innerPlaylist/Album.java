package innerPlaylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = songs.findSong(title);
        if (song == null) {
            System.out.println("The song " + title + " is not in this album");
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
        Song song = songs.findSong(trackNumber);
        if (song == null) {
            System.out.println("This album does not have a track " + trackNumber);
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

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (findSong(song.getTitle()) != null) {
                return false;
            } else {
                songs.add(song);
                return true;
            }
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }

            return null;
        }

        private Song findSong(int trackNumber) {
            if (trackNumber > 0 && trackNumber <= songs.size()) {
                return songs.get(trackNumber - 1);
            }

            return null;
        }
    }
}
