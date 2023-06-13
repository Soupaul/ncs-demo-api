package com.soupaul.ncsdemoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.soupaul.ncsdemoapi.models.Song;

public interface SongRepository extends MongoRepository<Song, String> {

}
