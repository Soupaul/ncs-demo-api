package com.soupaul.ncsdemoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soupaul.ncsdemoapi.models.Song;
import com.soupaul.ncsdemoapi.repository.SongRepository;

@RestController
public class SongsController {

    @Autowired
    private SongRepository songRepo;

    @GetMapping("/allSongs")
    public List<Song> getAllSongs() {

        return songRepo.findAll();
    }

}
