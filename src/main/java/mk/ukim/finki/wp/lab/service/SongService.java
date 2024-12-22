package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);

    //void addNewSong(Song newSong);

    Song findBySongId(long songId);

    void deleteSongById(long id);

    void addNewSong(String title, String genre, String trackId, int i, Album wantedAlbum);
}
