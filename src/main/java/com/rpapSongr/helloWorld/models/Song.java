package com.rpapSongr.helloWorld.models;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private Double length;
    private Integer trackNumber;
    @ManyToOne
    private Album album;

    protected Song() {
    }

    //Album album taken out
    public Song(String title, Double length, Integer trackNumber, Album album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", trackNumber=" + trackNumber +
                ", album='" + album + '\'' +
                '}';
    }

}
