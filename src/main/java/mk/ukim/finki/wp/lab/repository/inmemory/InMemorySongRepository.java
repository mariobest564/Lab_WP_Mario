package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemorySongRepository {
    public static List<Song> songList = new ArrayList<>();

    public InMemorySongRepository() {
        songList.add(new Song("Eyes Without a face", "Rock","1", 1983,new Album("RockAlbum","Rock","2009")));
        songList.add(new Song("Gruv Nokjen", "Rap","2", 2019,new Album("RapAlbum","Rap","2014")));
        songList.add(new Song("Espresso", "Pop","3", 2024,new Album("PopAlbum","Pop","2024")));
        songList.add(new Song("Emotionless", "Rap","4", 2018,new Album("RapAlbum","Rap","2020")));
        songList.add(new Song("Nemoj", "Rap","5", 2014,new Album("MetalAlbum","Metal","2010")));
    }

    public List<Song> findAll() {
        return songList;
    }

    public Song findByTrackId(String trackId){
        return songList.stream()
                .filter(item->item.getTrackId().equals(trackId))
                .findFirst()
                .orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song){
        song.getPerformers().add(artist);
        return artist;
    }

    /*public void addNewSong(String title, String genre, String trackId, int year, Album wantedAlbum) {
        songList.removeIf(item->item.getTitle().equals(title));
        Song newSong = new Song(title,genre,trackId,year);
        newSong.setAlbum(wantedAlbum);
        songList.add(newSong);
    }*/

    public Song findBySongId(long songId) {
        return songList.stream().filter(item -> item.getId().equals(songId)).findFirst().orElse(null);
    }

    public void removeSong(long id) {
        songList.removeIf(item->item.getId().equals(id));
    }
}
