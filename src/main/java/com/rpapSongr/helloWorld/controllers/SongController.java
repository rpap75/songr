package com.rpapSongr.helloWorld.controllers;

import com.rpapSongr.helloWorld.models.Album;
import com.rpapSongr.helloWorld.models.Song;
import com.rpapSongr.helloWorld.repositories.AlbumRepository;
import com.rpapSongr.helloWorld.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songsRepository;


    //Get route to get ALL songs
    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        List<Song> albums = songsRepository.findAll();
        m.addAttribute("albums", albums);
        return "songs";
    }

    //Get route to create a song
    @PostMapping("/songs")
    public RedirectView createASong(String title, Double length, Integer trackNumber, String albumTitle) {
        Album album = albumRepository.findByTitle(albumTitle);
        Song newSong = new Song(title, length, trackNumber, album);
        songsRepository.save(newSong);
        return new RedirectView("/albums");
    }

}
