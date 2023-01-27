package com.rpapSongr.helloWorld.repositories;

import com.rpapSongr.helloWorld.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    public Album findByTitle(String title);
//    public Album findByArtist(String artist);
//    public Album findBySongCount(Integer songCount);
//    public Album findByLength(Double length);
//    public Album findByImageUrl(String imageUrl);
}
