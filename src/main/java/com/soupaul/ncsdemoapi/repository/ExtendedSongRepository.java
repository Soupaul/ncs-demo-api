package com.soupaul.ncsdemoapi.repository;

import java.util.List;

import com.soupaul.ncsdemoapi.models.Song;

public interface ExtendedSongRepository {

    List<Song> findByText(String text);

    List<Song> newReleases();
}
