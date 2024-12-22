package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryAlbumRepository {
    public static List<Album> albums = new ArrayList<>();

    public InMemoryAlbumRepository(){
        albums.add(new Album("Rap Album","Rap","2001"));
        albums.add(new Album("Pop Album","Pop","2024"));
        albums.add(new Album("Rock Album","Rock","2007"));
        albums.add(new Album("Metal Album","Metal","1992"));
    }

    public List<Album> findAll(){
        return albums;
    }

    public Album findAlbumById(String albumId) {
        return albums.stream()
                .filter(item->item.getId().equals(Long.parseLong(albumId)))
                .toList()
                .get(0);
    }
}
