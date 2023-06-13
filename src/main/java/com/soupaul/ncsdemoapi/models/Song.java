package com.soupaul.ncsdemoapi.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "songs")
public class Song {

    private String title;
    private String thumbnail;
    private String[] artists;
    private String genre;
    private LocalDateTime release_date;
    private String content;

}
