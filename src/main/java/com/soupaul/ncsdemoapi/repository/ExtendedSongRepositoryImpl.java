package com.soupaul.ncsdemoapi.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.soupaul.ncsdemoapi.models.Song;

@Component
public class ExtendedSongRepositoryImpl implements ExtendedSongRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Song> findByText(String text) {

        final List<Song> songs = new ArrayList<>();

        MongoDatabase database = client.getDatabase("ncs");
        MongoCollection<Document> collection = database.getCollection("songs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("title", "artists", "genre")))),
                new Document("$limit", 50L)));

        result.forEach(doc -> songs.add(converter.read(Song.class, doc)));

        return songs;

    }

    @Override
    public List<Song> newReleases() {

        final List<Song> songs = new ArrayList<>();

        MongoDatabase database = client.getDatabase("ncs");
        MongoCollection<Document> collection = database.getCollection("songs");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$sort",
                new Document("release_date", -1L)),
                new Document("$limit", 20L)));

        result.forEach(doc -> songs.add(converter.read(Song.class, doc)));

        return songs;

    }

}
