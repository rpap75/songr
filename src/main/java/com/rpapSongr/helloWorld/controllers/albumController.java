package com.rpapSongr.helloWorld.controllers;

import com.rpapSongr.helloWorld.models.Album;
import com.rpapSongr.helloWorld.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Album> listAlbums = albumRepository.findAll();
        m.addAttribute("albums", listAlbums);
        return "albums.html";
    }

    //post route to album
    @PostMapping("/albums")
    public RedirectView createAnAlbum(String title, String artist, Integer songCount, Double length, String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    //Get route to get ONE album
    @GetMapping("/albums/{id}")
    public String getOneAlbum(@PathVariable Long id, Model m) {
        Album returnedAlbum = albumRepository.findById(id).orElseThrow();
        m.addAttribute("albums", returnedAlbum);
        return "albums.html";
    }
}
