package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository inMemorySongRepository, AlbumRepository inMemoryAlbumRepository) {
        this.songRepository = inMemorySongRepository;
        this.albumRepository = inMemoryAlbumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }


    @Override
    public Song findBySongId(long songId) {
        return songRepository.findSongById(songId);
    }

    @Override
    public void deleteSongById(long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void addNewSong(String title, String genre, String trackId, int year, Album wantedAlbum) {
        Song wanted = new Song(title,genre,trackId,year,wantedAlbum);
        songRepository.save(wanted);
    }

    /*public void setAlbumsToSongs(){
        List<Album> albums = albumRepository.findAll();
        songRepository.findAll().stream()
                .filter(item->item.getAlbum()==null)
                .forEach(item->item.setAlbum(albums.stream().filter(i->i.getGenre().equals(item.getGenre())).toList().get(0)));
    }*/
}
