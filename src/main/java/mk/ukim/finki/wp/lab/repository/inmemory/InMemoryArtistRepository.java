package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryArtistRepository {

    public static List<Artist> artistList=new ArrayList<>();

    public InMemoryArtistRepository() {
        artistList.add(new Artist("Aubrey","Graham","Drizzy Drake from the 6"));
        artistList.add(new Artist("Sabrina","Carpenter","Mainstream"));
        artistList.add(new Artist("Strajk","Legijata","1L"));
        artistList.add(new Artist("Billy","Idol","Billy Idol was an early architect of the sound, style, and fury of punk rock. Billy was responsible for some of punk rock’s most memorable, literate, and evocative moments and created a pioneering new sound by bringing the spirit of ’77 to the dance floor, going on to fashion an immediately identifiable musical blueprint that integrates club-land throb, rockabilly desperation, and rock’n’roll decadence."));
        artistList.add(new Artist("LD","Pistolero","1L"));
    }

    public List<Artist> findAll(){
        return artistList;
    }

    public Artist findById(Long id){
        return artistList.stream()
                .filter(item->item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
