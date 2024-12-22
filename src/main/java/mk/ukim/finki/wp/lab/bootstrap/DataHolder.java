package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Album> albums;
    public static List<Artist> artistList;
    public static List<Song> songList;

    public final SongRepository songRepository;
    public final AlbumRepository albumRepository;
    public final ArtistRepository artistRepository;

    public DataHolder(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        albums = new ArrayList<>();
        artistList = new ArrayList<>();
        songList = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        albums.add(new Album("happy_mix","rock","1989"));
        albums.add(new Album("retro_mix","rap","2001"));
        albums.add(new Album("sad_mix","pop","2018"));
        albums.add(new Album("dev_mix","rock","2022"));

        albumRepository.saveAll(albums);

        songList.add(new Song("Bizuterija", "rock","1F", 1983,albumRepository.findAlbumByName("happy_mix")));
        songList.add(new Song("Lazy song", "pop","2K", 2019,albumRepository.findAlbumByName("sad_mix")));
        songList.add(new Song("Espresso", "pop","3L", 2024,albumRepository.findAlbumByName("dev_mix")));
        songList.add(new Song("Blank Space", "rap","4M", 2018,albumRepository.findAlbumByName("happy_mix")));
        songList.add(new Song("Den po den", "rap","5N", 2014,albumRepository.findAlbumByName("retro_mix")));

        songRepository.saveAll(songList);


        artistList.add(new Artist("Jelena","Rozga","Pretty women"));
        artistList.add(new Artist("Sabrina","Carpenter","Mainstream"));
        artistList.add(new Artist("Taylor","Swift","1L"));
        artistList.add(new Artist("Billy","Eilish","Performing sad songs"));
        artistList.add(new Artist("Vlado","Georgiev","The best of them"));
        artistRepository.saveAll(artistList);
    }

}
