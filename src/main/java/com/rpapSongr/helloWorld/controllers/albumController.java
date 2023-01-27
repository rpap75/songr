package com.rpapSongr.helloWorld.controllers;

import com.rpapSongr.helloWorld.models.Album;
import com.rpapSongr.helloWorld.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class albumController {

    @Autowired
    AlbumRepository albumRepository;

    // get splash page
    @GetMapping("/")
    public String getHome() {
        return "welcome.html";
    }

    // get /albums
    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        // first, create albums
//        Album album1 = new Album("Title", "Artist", 27, 27.59, "imageURL");
//        Album album2 = new Album("Title", "Artist", 27, 27.59, "imageURL");
//        Album album3 = new Album("Title", "Artist", 27, 27.59, "imageURL");
        // second, create an ArrayList to hold them
        List<Album> listAlbums = albumRepository.findAll();
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
        // then send the albums to the view
        // Using the Model, include key:value pairs
        m.addAttribute("albums", listAlbums);
        // return to the template of album
        return "albums.html";
    }

    //post route to album
    @PostMapping("/albums")
    public RedirectView createAnAlbum(String title, String artist, Integer songCount, Double length, String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
}
