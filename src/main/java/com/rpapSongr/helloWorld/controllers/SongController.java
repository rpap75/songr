package com.rpapSongr.helloWorld.controllers;

import com.rpapSongr.helloWorld.models.Song;
import com.rpapSongr.helloWorld.repositories.AlbumRepository;
import com.rpapSongr.helloWorld.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songsRepository;


    //Get route to get ALL songs

    //Get route to get ONE album

    //Put route to add songs to an album

    //Get route to get ALL songs for ONE album

    //Get route to create a song
    @PostMapping("/songs")
    public RedirectView createASong(String title, Double length, Integer trackNumber, String albumTitle) {
        AlbumRepository album = albumRepository.findByTitle(albumTitle);
        Song newSong = new Song(title, length, trackNumber, album);
        songsRepository.save(newSong);
        return new RedirectView("/albums");
    }

}
