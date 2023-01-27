package com.rpapSongr.helloWorld.repositories;

import com.rpapSongr.helloWorld.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    public Song findByTitle(String title);
}
