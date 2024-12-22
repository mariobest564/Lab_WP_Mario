package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.implementation.AlbumServiceImpl;
import mk.ukim.finki.wp.lab.service.implementation.SongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongController {

    private final SongServiceImpl songService;
    private final AlbumServiceImpl albumService;

    public SongController(SongServiceImpl songService, AlbumServiceImpl albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, @RequestParam(required = false) Long albumId, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
            model.addAttribute("hasError", true);
        }
        if (albumId != null) {
            model.addAttribute("songs", songService.listSongs().stream().filter(item -> item.getAlbum().getId().equals(albumId)));
        }
        //songService.setAlbumsToSongs();
        else {
            model.addAttribute("songs", songService.listSongs());
        }
        model.addAttribute("albums",albumService.findAll());
        return "listSongs";
    }

    @GetMapping("/songs/add-song-page")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "addSong";
    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam String releaseYear,
                           @RequestParam String albumId) {
        Album wantedAlbum = albumService.findAlbumById(Long.parseLong(albumId));
        //Song newSong = new Song(title,genre99,trackId,Integer.parseInt(releaseYear));
        //newSong.setAlbum(wantedAlbum);
        songService.addNewSong(title, genre, trackId, Integer.parseInt(releaseYear), wantedAlbum);
        return "redirect:/songs";
    }

    @GetMapping("/songs/edit-song/{id}")
    public String getEditSongForm(@PathVariable long id, Model model) {
        Song wanted = songService.findBySongId(id);
        if (wanted != null) {
            model.addAttribute("songToEdit", wanted);
            model.addAttribute("albums", albumService.findAll());

            return "addSong";
        }
        return "redirect:/songs?error=Song+You+Want+To+Edit+Is+Not+Found";

    }

    @GetMapping("/songs/delete-song/{id}")
    public String deleteSong(@PathVariable long id) {
        songService.deleteSongById(id);
        return "redirect:/songs";
    }

}
